package cn.eight.purcharseforward.dao;

import cn.eight.purcharseforward.pojo.User;
import cn.eight.purcharseforward.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private BasicDao dao=new BasicDao();

    public boolean queryUser(User user) {
        boolean result=false;
        Connection con = DbPool.getConnection();
        PreparedStatement pst =null;
        ResultSet rs =null;
        String sql="select count(*) from user where username=? and password=? and rule=0";
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(con, pst, user.getUsername(), user.getPassword());
            if(rs!=null&&rs.next()&&rs.getInt(1)==1){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(rs,pst,con);
        }
        return result;
    }
}

package cn.eight.purcharseforward.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//项目中对数据库的操作分为两大部分，一为查询，一为增删改
//公共的dao类，实现一些公共的功能，减少代码冗余
public class BasicDao {
    //公共的查询方法
    public ResultSet execQuery(Connection con , PreparedStatement pst,Object...params){
        ResultSet rs =null;
        //针对占位符传参
        try {
            if (params != null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i+1,params[i]);
                }
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    //公共的修改方法
    public void execUpdate(Connection con , PreparedStatement pst,Object...params) throws SQLException {
        //针对占位符传参，该方法中的异常不能被捕获，一旦捕获，则事务不能正常提交
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i+1,params[i]);
            }
        }
        pst.executeUpdate();
    }
    //公共的释放资源的方法
    public void releaseResource(ResultSet rs,PreparedStatement pst,Connection con){
        try {
            if(rs!=null){
                rs.close();
            }
            if(pst!=null){
                pst.close();
            }
            if(con!=null){
                con.close();
                con=null;//归还连接
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

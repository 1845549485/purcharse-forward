package cn.eight.purcharseforward.service.Impl;

import cn.eight.purcharseforward.dao.UserDao;
import cn.eight.purcharseforward.pojo.User;
import cn.eight.purcharseforward.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDao();
    @Override
    public boolean checkUser(User user) {
        return userDao.queryUser(user);
    }
}

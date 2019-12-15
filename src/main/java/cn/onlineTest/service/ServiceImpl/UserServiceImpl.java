package cn.onlineTest.service.ServiceImpl;

import cn.onlineTest.dao.UserDao;
import cn.onlineTest.dao.daoImpl.UserDaoImpl;
import cn.onlineTest.entity.UserBean;
import cn.onlineTest.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public boolean add(UserBean userBean) {
        return userDao.add(userBean);
    }

    @Override
    public List<Map<String, Object>> select(UserBean userBean) {
        return userDao.select(userBean);
    }

    @Override
    public List<Map<String, Object>> select(String userName) {
        return userDao.select(userName);
    }
}

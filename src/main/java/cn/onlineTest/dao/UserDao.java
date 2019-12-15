package cn.onlineTest.dao;

import cn.onlineTest.entity.UserBean;

import java.util.List;
import java.util.Map;

public interface UserDao {
    boolean add(UserBean userBean);

    List<Map<String,Object>> select(UserBean userBean);

    List<Map<String,Object>> select(String userName);
}

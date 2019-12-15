package cn.onlineTest.service;

import cn.onlineTest.entity.UserBean;

import java.util.List;
import java.util.Map;

public interface UserService {
    boolean add(UserBean userBean);

    List<Map<String,Object>> select(UserBean userBean);

    List<Map<String,Object>> select(String userName);
}

package cn.onlineTest.service;


import cn.onlineTest.entity.StudentBean;

import java.util.List;
import java.util.Map;

public interface StudentService {
    boolean add(StudentBean studentBean);
    List<Map<String,Object>> select();
}

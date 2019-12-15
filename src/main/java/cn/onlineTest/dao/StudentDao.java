package cn.onlineTest.dao;


import cn.onlineTest.entity.StudentBean;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    boolean add(StudentBean studentean);

    List<Map<String,Object>> select();
}

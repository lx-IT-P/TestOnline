package cn.onlineTest.dao;

import cn.onlineTest.entity.ExamBean;

import java.util.List;
import java.util.Map;

public interface ExamDao {
    boolean add(ExamBean examBean);
    List<Map<String,Object>> select();

}

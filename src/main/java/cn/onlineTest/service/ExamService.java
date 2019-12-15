package cn.onlineTest.service;

import cn.onlineTest.entity.ExamBean;

import java.util.List;
import java.util.Map;

public interface ExamService {
    boolean add(ExamBean examBean);
    List<Map<String,Object>> select();
}

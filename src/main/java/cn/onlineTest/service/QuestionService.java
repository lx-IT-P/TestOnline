package cn.onlineTest.service;

import cn.onlineTest.entity.QuestionBean;

import java.util.List;
import java.util.Map;

public interface QuestionService {
    boolean add(QuestionBean questionBean);

    List<Map<String,Object>> select();

    List<Map<String,Object>> selectTestBysubid(String subid);
}

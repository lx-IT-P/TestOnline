package cn.onlineTest.service;

import cn.onlineTest.entity.Answer;

import java.util.List;
import java.util.Map;

public interface AnswerService {
    boolean add(Answer answer);
    List<Map<String,Object>> select();
}

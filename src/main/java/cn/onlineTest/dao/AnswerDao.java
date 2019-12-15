package cn.onlineTest.dao;

import cn.onlineTest.entity.Answer;

import java.util.List;
import java.util.Map;

public interface AnswerDao {
    boolean add(Answer answer);
    List<Map<String,Object>> select();
}

package cn.onlineTest.service.ServiceImpl;

import cn.onlineTest.dao.AnswerDao;
import cn.onlineTest.dao.daoImpl.AnswerImplDao;
import cn.onlineTest.entity.Answer;
import cn.onlineTest.service.AnswerService;

import java.util.List;
import java.util.Map;

public class AnswerServiceImpl  implements AnswerService {

AnswerDao answerDao = new AnswerImplDao();
    @Override
    public boolean add(Answer answer) {
        return answerDao.add(answer);
    }

    @Override
    public List<Map<String, Object>> select() {
        return answerDao.select();
    }
}

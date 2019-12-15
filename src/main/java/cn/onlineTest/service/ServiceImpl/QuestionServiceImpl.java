package cn.onlineTest.service.ServiceImpl;

import cn.onlineTest.dao.QuestionDao;
import cn.onlineTest.dao.daoImpl.QuestionDaoImpl;
import cn.onlineTest.entity.QuestionBean;
import cn.onlineTest.service.QuestionService;

import java.util.List;
import java.util.Map;

public class QuestionServiceImpl implements QuestionService {
    QuestionDao questionDao=new QuestionDaoImpl();
    @Override
    public boolean add(QuestionBean questionBean) {
        return questionDao.add(questionBean);
    }

    @Override
    public List<Map<String, Object>> select() {
        return questionDao.select();
    }

    @Override
    public List<Map<String, Object>> selectTestBysubid(String subid) {
        return questionDao.selectTestBysubid(subid);
    }
}

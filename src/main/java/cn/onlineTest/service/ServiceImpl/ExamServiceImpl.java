package cn.onlineTest.service.ServiceImpl;

import cn.onlineTest.dao.ExamDao;
import cn.onlineTest.dao.daoImpl.ExamDaoImpl;
import cn.onlineTest.entity.ExamBean;
import cn.onlineTest.service.ExamService;

import java.util.List;
import java.util.Map;

public class ExamServiceImpl implements ExamService {
    ExamDao examDao=new ExamDaoImpl();
    @Override
    public boolean add(ExamBean examBean) {
        return examDao.add(examBean);
    }

    @Override
    public List<Map<String, Object>> select() {
        return examDao.select();
    }
}

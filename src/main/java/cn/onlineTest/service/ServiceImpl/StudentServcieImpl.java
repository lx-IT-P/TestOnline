package cn.onlineTest.service.ServiceImpl;

import cn.onlineTest.dao.StudentDao;
import cn.onlineTest.dao.daoImpl.StudentImplDao;
import cn.onlineTest.entity.StudentBean;
import cn.onlineTest.service.StudentService;

import java.util.List;
import java.util.Map;

public class StudentServcieImpl implements StudentService {
    StudentDao studentDao = new StudentImplDao();
    @Override
    public boolean add(StudentBean studentBean) {
        return studentDao.add(studentBean);
    }

    @Override
    public List<Map<String, Object>> select() {
        return studentDao.select();
    }
}

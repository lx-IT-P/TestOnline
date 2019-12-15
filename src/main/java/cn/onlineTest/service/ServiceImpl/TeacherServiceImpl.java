package cn.onlineTest.service.ServiceImpl;

import cn.onlineTest.dao.TeacherDao;
import cn.onlineTest.dao.daoImpl.TeacherDaoImpl;
import cn.onlineTest.entity.TeacherBean;
import cn.onlineTest.service.TeacherService;

import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao=new TeacherDaoImpl();
    @Override
    public boolean add(TeacherBean teacherBean) {
        return teacherDao.add(teacherBean);
    }

    @Override
    public List<Map<String, Object>> selectByusername(String username) {
        return teacherDao.selectByusername(username);
    }
}

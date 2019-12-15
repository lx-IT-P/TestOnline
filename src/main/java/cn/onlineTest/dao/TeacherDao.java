package cn.onlineTest.dao;

import cn.onlineTest.entity.TeacherBean;

import java.util.List;
import java.util.Map;

public interface TeacherDao {
    boolean add(TeacherBean teacherBean);

    List<Map<String,Object>> selectByusername(String username);
}

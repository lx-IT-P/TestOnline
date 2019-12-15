package cn.onlineTest.service;

import cn.onlineTest.entity.TeacherBean;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    boolean add(TeacherBean teacherBean);

    List<Map<String,Object>> selectByusername(String username);
}

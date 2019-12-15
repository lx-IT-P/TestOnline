package cn.onlineTest.dao.daoImpl;

import cn.onlineTest.dao.StudentDao;
import cn.onlineTest.entity.StudentBean;
import cn.onlineTest.utils.BaseDaoutil;
import cn.onlineTest.utils.ConnUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentImplDao  extends BaseDaoutil implements StudentDao {

    @Override
    public boolean add(StudentBean studentBean) {
        String sql="INSERT INTO student(stu_id,stu_name,stu_sex,stu_age,stu_email,stu_phone) VALUES(?,?,?,?,?,?)";
        Object[] Exam_ob={studentBean.getStu_id(),studentBean.getStu_name(),studentBean.getStu_sex(),studentBean.getStu_age(),studentBean.getStu_email(),studentBean.getStu_phone()};
        super.update(sql,Exam_ob);
        return true;
    }
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    @Override
    public List<Map<String, Object>> select() {
        List<Map<String, Object>> list = new ArrayList<>();
        conn = ConnUtil.getConnextion();
        String sql="SELECT * FROM student";
        try {
            pstmt = conn.prepareStatement(sql);
            int count = pstmt.getParameterMetaData().getParameterCount();
            rs=pstmt.executeQuery();
            //拿到结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列的个数
            int colunmCount = rsmd.getColumnCount();
            while(rs.next()){
                Map<String,Object> map=new HashMap<>();
                for (int i = 1; i <= colunmCount; i++) {
                    map.put(rsmd.getColumnName(i),rs.getObject(i));
                }
                list.add(map);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

package cn.onlineTest.dao.daoImpl;

import cn.onlineTest.dao.ExamDao;
import cn.onlineTest.entity.ExamBean;
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

public class ExamDaoImpl extends BaseDaoutil implements ExamDao {
    @Override
    public boolean add(ExamBean examBean) {
        String sql="INSERT INTO exam(exam_name,tea_id,test_id,score) VALUES(?,?,?,?)";
        Object[] Exam_ob={examBean.getExam_name(),examBean.getTea_id(),examBean.getTest_id(),examBean.getScore()};
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
        String sql="SELECT * FROM exam";
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

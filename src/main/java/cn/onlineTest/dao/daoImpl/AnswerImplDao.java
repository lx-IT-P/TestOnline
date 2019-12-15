package cn.onlineTest.dao.daoImpl;

import cn.onlineTest.dao.AnswerDao;
import cn.onlineTest.entity.Answer;
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

public class AnswerImplDao extends BaseDaoutil implements AnswerDao {


    @Override
    public boolean add(Answer answer) {
        String sql="INSERT INTO answer(answer,answer_id,stu_id,exam_id )VALUES(?,?,?,?)";
        Object[] answer_Ob={answer.getAnswer(),answer.getAnswer_id(),answer.getStu_id(),answer.getExam_id()};
        super.update(sql,answer_Ob);
        return true;
    }
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    @Override
    public List<Map<String, Object>> select() {
        List<Map<String, Object>> list = new ArrayList<>();
        conn = ConnUtil.getConnextion();
        String sql="SELECT * FROM answer";
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

package cn.onlineTest.dao.daoImpl;

import cn.onlineTest.dao.QuestionDao;
import cn.onlineTest.entity.QuestionBean;
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

public class QuestionDaoImpl extends BaseDaoutil implements QuestionDao {
    @Override
    public boolean add(QuestionBean questionBean) {
        String sql="INSERT INTO test(test_name,option1,option2,option3,option4,correct,sub_id) VALUES(?,?,?,?,?,?,?)";
        Object[] question_Ob={questionBean.getTest_name(),questionBean.getOption1(),questionBean.getOption2(),questionBean.getOption3(),questionBean.getOption4(),questionBean.getCorrect(),questionBean.getSub_id()};
        super.update(sql,question_Ob);
        return true;
    }
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    @Override
    public List<Map<String, Object>> select() {
        List<Map<String, Object>> list = new ArrayList<>();
        conn = ConnUtil.getConnextion();
        String sql="SELECT * FROM test";
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

    @Override
    public List<Map<String, Object>> selectTestBysubid(String subid) {
        List<Map<String, Object>> list = new ArrayList<>();
        conn = ConnUtil.getConnextion();
        String sql="SELECT * FROM test WHERE sub_id="+subid;
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

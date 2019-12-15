package cn.onlineTest.dao.daoImpl;

import cn.onlineTest.dao.TeacherDao;
import cn.onlineTest.entity.TeacherBean;
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

public class TeacherDaoImpl extends BaseDaoutil implements TeacherDao {
    @Override
    public boolean add(TeacherBean teacherBean) {
        String sql="INSERT into teacher(tea_name) VALUES(?)";
        Object[] tea_Ob={teacherBean.getTea_Name()};
        super.update(sql,tea_Ob);
        return true;
    }
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    @Override
    public List<Map<String, Object>> selectByusername(String username) {
        List<Map<String, Object>> list = new ArrayList<>();
        conn = ConnUtil.getConnextion();
        String sql="SELECT * FROM teacher WHERE tea_name='"+username+"'";
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

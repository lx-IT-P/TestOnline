package cn.onlineTest.dao.daoImpl;

import cn.onlineTest.dao.UserDao;
import cn.onlineTest.entity.UserBean;
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

public class UserDaoImpl extends BaseDaoutil implements UserDao {
    @Override
    public boolean add(UserBean userBean) {
        String sql = "INSERT INTO user(user_name,user_pwd,identity) VALUES(?,?,?)";
        Object[] user_Ob = {userBean.getUser_name(), userBean.getUser_pwd(), userBean.getUser_identity()};
        super.update(sql, user_Ob);
        return true;
    }

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    @Override
    public List<Map<String, Object>> select(UserBean userBean) {
        List<Map<String, Object>> list = new ArrayList<>();
        conn = ConnUtil.getConnextion();
//        String sql="SELECT * FROM user WHERE user_name='"+userBean.getUser_name()+"' AND user_pwd='"+userBean.getUser_pwd()+"' AND identity='"+userBean.getUser_identity()+"'";
//        String sql="SELECT * FROM user";
        String sql="SELECT * FROM user WHERE user_name='"+userBean.getUser_name()+"' AND user_pwd='"+userBean.getUser_pwd()+"'";

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
    public List<Map<String, Object>> select(String userName) {
        List<Map<String, Object>> list = new ArrayList<>();
        conn = ConnUtil.getConnextion();
        String sql="SELECT * FROM user WHERE user_name='"+userName+"'";
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

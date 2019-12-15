package cn.onlineTest.entity;

public class UserBean {
    private String user_name;
    private String user_pwd;
    private String user_identity;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_identity() {
        return user_identity;
    }

    public void setUser_identity(String user_identity) {
        this.user_identity = user_identity;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_identity='" + user_identity + '\'' +
                '}';
    }
}

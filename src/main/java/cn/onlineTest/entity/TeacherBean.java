package cn.onlineTest.entity;

public class TeacherBean {
    private  int Tea_Id;
    private String Tea_Name;
    private  int Tea_Age;
    private  String Tea_Sex;
    private String Tea_Sub;
    private String Tea_Email;
    private String Tea_Phone;

    public int getTea_Id() {
        return Tea_Id;
    }

    public void setTea_Id(int tea_Id) {
        Tea_Id = tea_Id;
    }

    public String getTea_Name() {
        return Tea_Name;
    }

    public void setTea_Name(String tea_Name) {
        Tea_Name = tea_Name;
    }

    public int getTea_Age() {
        return Tea_Age;
    }

    public void setTea_Age(int tea_Age) {
        Tea_Age = tea_Age;
    }

    public String getTea_Sex() {
        return Tea_Sex;
    }

    public void setTea_Sex(String tea_Sex) {
        Tea_Sex = tea_Sex;
    }

    public String getTea_Sub() {
        return Tea_Sub;
    }

    public void setTea_Sub(String tea_Sub) {
        Tea_Sub = tea_Sub;
    }

    public String getTea_Email() {
        return Tea_Email;
    }

    public void setTea_Email(String tea_Email) {
        Tea_Email = tea_Email;
    }

    public String getTea_Phone() {
        return Tea_Phone;
    }

    public void setTea_Phone(String tea_Phone) {
        Tea_Phone = tea_Phone;
    }

    @Override
    public String toString() {
        return "TeacherBean{" +
                "Tea_Id=" + Tea_Id +
                ", Tea_Name='" + Tea_Name + '\'' +
                ", Tea_Age=" + Tea_Age +
                ", Tea_Sex='" + Tea_Sex + '\'' +
                ", Tea_Sub='" + Tea_Sub + '\'' +
                ", Tea_Email='" + Tea_Email + '\'' +
                ", Tea_Phone='" + Tea_Phone + '\'' +
                '}';
    }
}

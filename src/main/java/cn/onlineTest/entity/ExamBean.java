package cn.onlineTest.entity;

public class ExamBean {
    private int exam_id;
    private String exam_name;
    private int tea_id;
    private String test_id;
    private float score;

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public int getTea_id() {
        return tea_id;
    }

    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ExamBean{" +
                "exam_id=" + exam_id +
                ", exam_name='" + exam_name + '\'' +
                ", tea_id=" + tea_id +
                ", test_id='" + test_id + '\'' +
                ", score=" + score +
                '}';
    }
}

package cn.onlineTest.entity;

public class Answer {
    private int answer_id;
    private  int stu_id;
    private  int exam_id;
    private String answer;

    @Override
    public String toString() {
        return "Answer{" +
                "answer_id=" + answer_id +
                ", stu_id=" + stu_id +
                ", exam_id=" + exam_id +
                ", answer=" + answer +
                '}';
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

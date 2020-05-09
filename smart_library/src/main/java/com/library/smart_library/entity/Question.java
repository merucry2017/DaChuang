package com.library.smart_library.entity;

public class Question extends Book {

    private Integer uid;
    private Integer qid;
    private Integer wid;
    private String question;
    private String answer;

    public Question() {
    }

    public Question(Integer uid, Integer qid, Integer wid, String question, String answer) {
        this.uid = uid;
        this.qid = qid;
        this.wid = wid;
        this.question = question;
        this.answer = answer;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    @Override
    public String toString() {
        return "Question{" +
                "uid=" + uid +
                ", qid=" + qid +
                ", wid=" + wid +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}

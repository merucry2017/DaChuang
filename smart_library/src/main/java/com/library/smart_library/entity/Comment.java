package com.library.smart_library.entity;

public class Comment extends Book{

    private Integer cid;
    private Integer uid;
    private Integer bid;
    private String comment;
    private String username;

    public Comment() {
    }

    public Comment(Integer cid, Integer uid, Integer bid, String comment, String username) {
        this.cid = cid;
        this.uid = uid;
        this.bid = bid;
        this.comment = comment;
        this.username = username;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", bid=" + bid +
                ", comment='" + comment + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

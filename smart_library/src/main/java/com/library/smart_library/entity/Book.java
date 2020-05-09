package com.library.smart_library.entity;

public class Book extends BaseEntity{

    private Integer bid;
    private String writer;
    private String btype;
    private String title;
    private String content;
    private String image;
    private String publishTime;
    private String page;
    private String diffcult;

    public Book() {
    }

    public Book(Integer bid, String writer, String btype, String title, String content, String image, String publishTime, String page, String diffcult) {
        this.bid = bid;
        this.writer = writer;
        this.btype = btype;
        this.title = title;
        this.content = content;
        this.image = image;
        this.publishTime = publishTime;
        this.page = page;
        this.diffcult = diffcult;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getDiffcult() {
        return diffcult;
    }

    public void setDiffcult(String diffcult) {
        this.diffcult = diffcult;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", writer='" + writer + '\'' +
                ", btype='" + btype + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", page='" + page + '\'' +
                ", diffcult='" + diffcult + '\'' +
                '}';
    }
}

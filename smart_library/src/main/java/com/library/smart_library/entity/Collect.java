package com.library.smart_library.entity;

public class Collect extends Book {

    private Integer uid;

    public Collect() {
    }

    public Collect(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "uid=" + uid +
                '}';
    }
}

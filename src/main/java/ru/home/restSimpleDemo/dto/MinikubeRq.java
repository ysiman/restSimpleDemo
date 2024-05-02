package ru.home.restSimpleDemo.dto;

public class MinikubeRq {
    private String uid;

    public MinikubeRq() {
    }

    public MinikubeRq(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}

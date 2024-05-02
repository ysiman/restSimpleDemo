package ru.home.restSimpleDemo.dto;

public class MinikubeRs {
    private String message;

    public MinikubeRs() {
    }

    public MinikubeRs(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package ru.home.restSimpleDemo.dto.validation;

public class ValidationError {
    private String code;
    private String desc;

    public ValidationError(String code) {
        this.code = code;
    }

    public ValidationError(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

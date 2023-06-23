package com.example.onlinerent.model;

public class RespBean {
    private Integer status;
    private String message;
    private Object data;


    public static RespBean ok(String message, Object data) {
        return new RespBean(200,message,data);
    }
    public static RespBean ok(String message) {
        return new RespBean(200,message,null);
    }
    public static RespBean error(String message) {
        return new RespBean(500,message,null);
    }
    public static RespBean error(String message, Object data) {
        return new RespBean(500,message,null);
    }

    public RespBean(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

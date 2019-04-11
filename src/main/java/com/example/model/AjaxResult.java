package com.example.model;

/**
 * Created by liulq on 2017-11-15 .
 */
public class AjaxResult {
    private int code = 200;

    private String msg = "ok";

    private Object result;
    public AjaxResult(){}

    public AjaxResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AjaxResult(Object result) {
        this(200, "OK");
        this.result = result;
    }

    public static AjaxResult error() {
        return error(500, "error");
    }

    public static AjaxResult error(String msg) {
        return error(500, msg);
    }

    public static AjaxResult error(int code, String msg) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setMsg(msg);
        return ajaxResult;
    }

    public static AjaxResult ok(Object data) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setResult(data);
        return ajaxResult;
    }

    public static AjaxResult ok() {
        return new AjaxResult();
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "AjaxResult [code=" + code + ", msg=" + msg + ", result=" + result + "]";
    }
}

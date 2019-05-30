package com.zirfee.blog.utils;

public class commonResult {
    private Integer state;
    private String  msg;
    private Object  data;

    public commonResult(){
        this.state=200;
        this.msg="success";
    }

    public commonResult(Object ob){
        this();
        this.data=ob;
    }

    public commonResult(Integer state,String msg){
        this.state=state;
        this.msg=msg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

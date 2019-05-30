package com.zirfee.blog.utils;

public class ResultUtil {

    public static commonResult success(){
        return new commonResult();
    }
    public static commonResult success(Object ob){
        return new commonResult(ob);
    }
    public static commonResult error(Integer state,String msg){
        return new commonResult(state,msg);
    }

}

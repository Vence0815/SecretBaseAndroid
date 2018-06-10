package com.renrun.secretbase_android.dataCore.bean;

/**
 * Created by vence on 2018/6/10 17:43
 * 邮箱 ：vence0815@foxmail.com
 */
public class BaseBean {

    public static final int  SUCCESS = 0;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;
    private String msg;

}

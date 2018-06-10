package com.renrun.secretbase_android.utils;

import android.widget.Toast;


import com.renrun.secretbase_android.app.MyApplication;

import es.dmoral.toasty.Toasty;

/**
 * Created by vence on 2018/5/10 16:06
 * 邮箱 ：vence0815@foxmail.com
 */
public class ToastHelper {

    public static void errorWithicon(String msg) {
        Toasty.error(MyApplication.getAppComponent().getContext(), msg, Toast.LENGTH_SHORT, true).show();
    }

    public static void successWithicon(String msg) {
        Toasty.success(MyApplication.getAppComponent().getContext(), msg, Toast.LENGTH_SHORT, true).show();
    }

    public static void infoWithicon(String msg) {
        Toasty.info(MyApplication.getAppComponent().getContext(), msg, Toast.LENGTH_SHORT, true).show();
    }

    public static void warningWithicon(String msg) {
        Toasty.warning(MyApplication.getAppComponent().getContext(), msg, Toast.LENGTH_SHORT, true).show();
    }

    public static void normal(String msg) {
        Toasty.normal(MyApplication.getAppComponent().getContext(), msg).show();
    }

}

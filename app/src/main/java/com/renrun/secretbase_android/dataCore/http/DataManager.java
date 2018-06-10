package com.renrun.secretbase_android.dataCore.http;


import com.renrun.secretbase_android.dataCore.bean.LoginInfoBean;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by vence on 2018/4/27 15:02
 * 邮箱 ：vence0815@foxmail.com
 * <p>
 * 数据管理类，网络，sp ，数据库等数据操作
 */
public class DataManager implements HttpHelper {

    private HttpHelper mHttpHelper;

    public DataManager(HttpHelper httpHelper) {
        mHttpHelper = httpHelper;
    }

    @Override
    public Observable<LoginInfoBean> login(Map<String, String> map) {
        return mHttpHelper.login(map);
    }
}

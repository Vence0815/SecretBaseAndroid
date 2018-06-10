package com.renrun.secretbase_android.dataCore.http;


import com.renrun.secretbase_android.dataCore.bean.LoginInfoBean;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by vence on 2018/4/27 15:13
 * 邮箱 ：vence0815@foxmail.com
 */
public interface HttpHelper {

    Observable<LoginInfoBean> login(Map<String, String> map);

}

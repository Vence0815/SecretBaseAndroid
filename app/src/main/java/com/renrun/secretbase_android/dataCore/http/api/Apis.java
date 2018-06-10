package com.renrun.secretbase_android.dataCore.http.api;


import com.renrun.secretbase_android.dataCore.bean.LoginInfoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by vence on 2018/4/27 15:22
 * 邮箱 ：vence0815@foxmail.com
 * <p>
 * 接口地址
 */
public interface Apis {

    /**
     * 登陆接口
     *
     * @return SessionBean
     */
    @FormUrlEncoded
    @POST("users/login")
    Observable<LoginInfoBean> login(
            @FieldMap Map<String, String> map);
}


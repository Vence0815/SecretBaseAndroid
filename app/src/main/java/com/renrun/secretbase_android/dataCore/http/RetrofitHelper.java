package com.renrun.secretbase_android.dataCore.http;

import com.renrun.secretbase_android.dataCore.bean.LoginInfoBean;
import com.renrun.secretbase_android.dataCore.http.api.Apis;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by vence on 2018/4/27 15:21
 * 邮箱 ：vence0815@foxmail.com
 */
public class RetrofitHelper implements HttpHelper {

    private Apis mApi;

    @Inject
    RetrofitHelper(Apis mApi) {
        this.mApi = mApi;
    }


    @Override
    public Observable<LoginInfoBean> login(Map<String, String> map) {
        return mApi.login(map);
    }
}

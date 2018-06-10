package com.renrun.secretbase_android.di.module;

import com.renrun.secretbase_android.app.MyApplication;
import com.renrun.secretbase_android.dataCore.http.DataManager;
import com.renrun.secretbase_android.dataCore.http.HttpHelper;
import com.renrun.secretbase_android.dataCore.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vence on 2018/4/27 14:53
 * 邮箱 ：vence0815@foxmail.com
 */
@Module
public class AppModule {

    private final MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplicationContext() {
        return application;
    }



    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper) {
        //这两个参数是下面两个方法提供的
        return new DataManager(httpHelper);
    }


    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

}

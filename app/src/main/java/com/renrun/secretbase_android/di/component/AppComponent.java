package com.renrun.secretbase_android.di.component;

import com.renrun.secretbase_android.app.MyApplication;
import com.renrun.secretbase_android.dataCore.http.DataManager;
import com.renrun.secretbase_android.di.module.AppModule;
import com.renrun.secretbase_android.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vence on 2018/4/27 14:51
 * 邮箱 ：vence0815@foxmail.com
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    /**
     * 全局的Context
     *
     * @return Context
     */
    MyApplication getContext();

    /**
     * 数据控制类
     *
     * @return DataManager
     */
    DataManager getDataManager();

}

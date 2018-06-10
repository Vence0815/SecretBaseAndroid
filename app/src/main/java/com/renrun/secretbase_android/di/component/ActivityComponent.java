package com.renrun.secretbase_android.di.component;

import android.app.Activity;

import com.renrun.secretbase_android.MainActivity;
import com.renrun.secretbase_android.di.module.ActivityModule;
import com.renrun.secretbase_android.di.scope.ActivityScope;
import com.renrun.secretbase_android.ui.activity.LoginActivity;

import dagger.Component;

/**
 * Created by vence on 2018/5/2 11:26
 * 邮箱 ：vence0815@foxmail.com
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    /**
     * 获取Activity实例
     *
     * @return Activity
     */
    Activity getActivity();

    /**
     * 注入MAinActivity所需的依赖
     *
     * @param mainActivity MainActivity
     */
    void inject(MainActivity mainActivity);

    /**
     * 注入LoginActivity所需的依赖
     *
     * @param loginActivity loginActivity
     */
    void inject(LoginActivity loginActivity);


}

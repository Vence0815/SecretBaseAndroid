package com.renrun.secretbase_android.di.component;

import android.app.Activity;

import com.renrun.secretbase_android.di.component.AppComponent;
import com.renrun.secretbase_android.di.module.FragmentModule;
import com.renrun.secretbase_android.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by vence on 2018/5/8 14:55
 * 邮箱 ：vence0815@foxmail.com
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    /**
     * 获取Activity实例
     *
     * @return Activity
     */
    Activity getActivity();

//    /**
//     * 注入homeFragment依赖
//     * @param homeFragment homeFragment
//     */
//    void inject(HomeFragment homeFragment);
//    void inject(FreshCarFragment homeFragment);
//    void inject(UsedCarFragment homeFragment);
//    void inject(MineFragment homeFragment);

}

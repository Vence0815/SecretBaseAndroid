package com.renrun.secretbase_android.di.module;

import android.app.Activity;


import com.renrun.secretbase_android.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vence on 2018/5/2 11:28
 * 邮箱 ：vence0815@foxmail.com
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return mActivity;
    }
}

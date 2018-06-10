package com.renrun.secretbase_android.base.activity;

import com.renrun.financingmvp.base.view.BaseView;
import com.renrun.secretbase_android.app.MyApplication;
import com.renrun.secretbase_android.base.presenter.AbstractPresenter;
import com.renrun.secretbase_android.di.component.ActivityComponent;
import com.renrun.secretbase_android.di.component.DaggerActivityComponent;
import com.renrun.secretbase_android.di.module.ActivityModule;
import com.renrun.secretbase_android.utils.ToastHelper;

import javax.inject.Inject;

/**
 * Created by vence on 2018/4/28 15:38
 * 邮箱 ：vence0815@foxmail.com
 */
public  abstract class BaseActivity <T extends AbstractPresenter> extends BaseSimpleActivity implements BaseView {
    @Inject
    protected T mPresenter;

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }


    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 注入当前Activity所需的依赖
     */
    protected abstract void initInject();

    @Override
    public void showNormal() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void reload() {

    }


    @Override
    public void showErrorMsg(String errorMsg) {
        ToastHelper.errorWithicon(errorMsg);
    }

}

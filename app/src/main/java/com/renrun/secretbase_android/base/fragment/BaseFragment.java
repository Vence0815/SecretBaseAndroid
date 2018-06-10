package com.renrun.secretbase_android.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.renrun.financingmvp.base.view.BaseView;
import com.renrun.secretbase_android.app.MyApplication;
import com.renrun.secretbase_android.base.presenter.AbstractPresenter;
import com.renrun.secretbase_android.di.component.DaggerFragmentComponent;
import com.renrun.secretbase_android.di.component.FragmentComponent;
import com.renrun.secretbase_android.di.module.FragmentModule;
import com.renrun.secretbase_android.utils.ToastHelper;

import javax.inject.Inject;

/**
 * Created by vence on 2018/5/8 14:51
 * 邮箱 ：vence0815@foxmail.com
 */
public abstract class BaseFragment<T extends AbstractPresenter> extends AbstractSimpleFragment implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        if (isAdded()) {
            ToastHelper.errorWithicon(errorMsg);
        }
    }

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

    /**
     * 注入当前Fragment所需的依赖
     */
    protected abstract void initInject();

}

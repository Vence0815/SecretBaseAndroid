package com.renrun.secretbase_android.base.presenter;

import com.renrun.financingmvp.base.view.BaseView;

import io.reactivex.disposables.Disposable;

/**
 * Created by vence on 2018/5/2 10:58
 * 邮箱 ：vence0815@foxmail.com
 */
public interface AbstractPresenter<T extends BaseView> {
    /**
     * 注入View
     *
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();

    /**
     * Add rxBing subscribe manager
     *
     * @param disposable Disposable
     */
    void addRxBindingSubscribe(Disposable disposable);


    /**
     * Set login status
     *
     * @param loginStatus login status
     */
    void setLoginStatus(boolean loginStatus);

    /**
     * Get login status
     *
     * @return if is login status
     */
    boolean getLoginStatus();

    /**
     * Get login account
     *
     * @return login account
     */
    String getLoginAccount();

    /**
     * Get current page
     *
     * @return current page
     */
    int getCurrentPage();

}

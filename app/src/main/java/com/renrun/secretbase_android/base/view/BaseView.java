package com.renrun.financingmvp.base.view;

/**
 * Created by vence on 2018/5/2 10:56
 * 邮箱 ：vence0815@foxmail.com
 */
public interface BaseView {
    /**
     * Show error message
     *
     * @param errorMsg error message
     */
    void showErrorMsg(String errorMsg);

    /**
     * showNormal
     */
    void showNormal();

    /**
     * Show error
     */
    void showError();

    /**
     * Show loading
     */
    void showLoading();

    /**
     * Reload
     */
    void reload();
}

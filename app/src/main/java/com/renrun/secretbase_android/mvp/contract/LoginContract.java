package com.renrun.secretbase_android.mvp.contract;


import com.renrun.secretbase_android.base.presenter.AbstractPresenter;
import com.renrun.secretbase_android.dataCore.bean.LoginInfoBean;

import java.util.Map;

/**
 * Created by vence on 2018/5/4 14:23
 * 邮箱 ：vence0815@foxmail.com
 */
public interface LoginContract {

    interface View extends com.renrun.financingmvp.base.view.BaseView {
        void loginResult(LoginInfoBean loginInfoBean);
    }

    interface Presenter extends AbstractPresenter<View> {
        void login(Map<String,String> map);
    }


}

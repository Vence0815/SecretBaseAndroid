package com.renrun.secretbase_android.mvp.presenter;

import com.renrun.secretbase_android.base.presenter.BasePresenter;
import com.renrun.secretbase_android.dataCore.BaseObserver;
import com.renrun.secretbase_android.dataCore.bean.BaseBean;
import com.renrun.secretbase_android.dataCore.bean.LoginInfoBean;
import com.renrun.secretbase_android.dataCore.http.DataManager;
import com.renrun.secretbase_android.mvp.contract.LoginContract;
import com.renrun.secretbase_android.mvp.contract.MainContract;
import com.renrun.secretbase_android.utils.RxUtils;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by vence on 2018/5/4 14:13
 * 邮箱 ：vence0815@foxmail.com
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

    @Override
    public void login(Map<String, String> map) {
        addSubscribe(mDataManager.login(map)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribeWith(new BaseObserver<LoginInfoBean>(mView) {
                    @Override
                    public void onNext(LoginInfoBean loginInfo) {
                        if (loginInfo.getCode() == BaseBean.SUCCESS) {
                            mView.loginResult(loginInfo);
                        } else {
                            mView.showErrorMsg(loginInfo.getMsg());
                        }
                    }
                })
        );
    }
}

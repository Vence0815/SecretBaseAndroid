package com.renrun.secretbase_android.mvp.presenter;

import com.renrun.secretbase_android.base.presenter.BasePresenter;
import com.renrun.secretbase_android.dataCore.http.DataManager;
import com.renrun.secretbase_android.mvp.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by vence on 2018/5/4 14:13
 * 邮箱 ：vence0815@foxmail.com
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }

}

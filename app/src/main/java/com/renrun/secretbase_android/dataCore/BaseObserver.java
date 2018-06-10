package com.renrun.secretbase_android.dataCore;

import android.text.TextUtils;

import com.renrun.secretbase_android.R;
import com.renrun.secretbase_android.app.MyApplication;
import com.renrun.secretbase_android.dataCore.http.ServerException;
import com.renrun.secretbase_android.utils.LogHelper;

import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

/**
 * @param <T> 在这里面统一处理错误的情况
 * @author quchao
 * @date 2017/11/27
 */

public abstract class BaseObserver<T> extends ResourceObserver<T> {

    private com.renrun.financingmvp.base.view.BaseView mView;
    private String mErrorMsg;
    private boolean isShowError = true;

    protected BaseObserver(com.renrun.financingmvp.base.view.BaseView view) {
        this.mView = view;
    }

    protected BaseObserver(com.renrun.financingmvp.base.view.BaseView view, String errorMsg) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected BaseObserver(com.renrun.financingmvp.base.view.BaseView view, boolean isShowError) {
        this.mView = view;
        this.isShowError = isShowError;
    }

    protected BaseObserver(com.renrun.financingmvp.base.view.BaseView view, String errorMsg, boolean isShowError) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowError = isShowError;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        LogHelper.e(e.getMessage());
        if (mView == null) {
            return;
        }
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof ServerException) {
            mView.showErrorMsg(e.toString());
        } else if (e instanceof HttpException) {
            mView.showErrorMsg(MyApplication.getInstance().getString(R.string.http_error));
        } else {
            mView.showErrorMsg(MyApplication.getInstance().getString(R.string.unKnown_error) + e.getMessage());
        }
        if (isShowError) {
            mView.showError();
        }
    }
}

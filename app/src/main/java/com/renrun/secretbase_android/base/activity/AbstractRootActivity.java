package com.renrun.secretbase_android.base.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.renrun.secretbase_android.R;
import com.renrun.secretbase_android.base.presenter.BasePresenter;

/**
 * Created by vence on 2018/5/2 11:19
 * 邮箱 ：vence0815@foxmail.com
 * 这个是有网络请求的带列表的里面有各种网络状态
 * @author vence
 */
public abstract class AbstractRootActivity<T extends BasePresenter> extends BaseActivity<T> {

    private static final int NORMAL_STATE = 0;
    private static final int LOADING_STATE = 1;
    public static final int ERROR_STATE = 2;

    private LottieAnimationView mLoadingAnimation;
    private View mLoadingView;
    private ViewGroup mNormalView;

    private int currentState = NORMAL_STATE;
    private View mErrorView;


    @Override
    protected void initEventAndData() {
        //每个recycle起名都要是统一的这个normal_view
        //todo 用上时候这句要打开
//        mNormalView = (ViewGroup) findViewById(R.id.normal_view);
        if (mNormalView == null) {
            throw new IllegalStateException(
                    "The subclass of RootActivity must contain a View named 'mNormalView'.");
        }
        if (!(mNormalView.getParent() instanceof ViewGroup)) {
            throw new IllegalStateException(
                    "mNormalView's ParentView should be a ViewGroup.");
        }
        ViewGroup mParent = (ViewGroup) mNormalView.getParent();
        View.inflate(this, R.layout.loading_view, mParent);
        View.inflate(this, R.layout.error_view, mParent);
        mLoadingView = mParent.findViewById(R.id.loading_group);
        mErrorView = mParent.findViewById(R.id.error_group);
        TextView reloadTv = mErrorView.findViewById(R.id.error_reload_tv);
        reloadTv.setOnClickListener(v -> reload());
        mLoadingAnimation = mLoadingView.findViewById(R.id.loading_animation);
        mErrorView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.GONE);
        mNormalView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        if (mLoadingAnimation != null) {
            mLoadingAnimation.cancelAnimation();
        }
        super.onDestroy();
    }


    private void hideCurrentView() {
        switch (currentState) {
            case NORMAL_STATE:
                mNormalView.setVisibility(View.GONE);
                break;
            case LOADING_STATE:
                mLoadingAnimation.cancelAnimation();
                mLoadingView.setVisibility(View.GONE);
                break;
            case ERROR_STATE:
                mErrorView.setVisibility(View.GONE);
            default:
                break;
        }
    }


    /**
     * 以下几个方法统一设置网络状态
     */
    @Override
    public void showLoading() {
        if (currentState == LOADING_STATE) {
            return;
        }
        hideCurrentView();
        currentState = LOADING_STATE;
        mLoadingView.setVisibility(View.VISIBLE);
        mLoadingAnimation.setAnimation("loading_bus.json");
        mLoadingAnimation.loop(true);
        mLoadingAnimation.playAnimation();
    }

    @Override
    public void showNormal() {
        if (currentState == NORMAL_STATE) {
            return;
        }
        hideCurrentView();
        currentState = NORMAL_STATE;
        mNormalView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {
        if (currentState == ERROR_STATE) {
            return;
        }
        hideCurrentView();
        currentState = ERROR_STATE;
        mErrorView.setVisibility(View.VISIBLE);
    }

}

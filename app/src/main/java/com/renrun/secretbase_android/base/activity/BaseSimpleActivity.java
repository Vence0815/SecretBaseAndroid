package com.renrun.secretbase_android.base.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.renrun.secretbase_android.R;
import com.renrun.secretbase_android.app.ActivityCollector;
import com.renrun.secretbase_android.utils.StatusBarUtils;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by vence on 2018/4/28 16:16
 * 邮箱 ：vence0815@foxmail.com
 * <p>
 * 简单基础的Activity没有网络请求的展示页面使用
 */
public abstract class BaseSimpleActivity extends SupportActivity {
    private Unbinder unBinder;
    protected BaseSimpleActivity mActivity;
    public static String START_ACTIVITY_INTENT = "START_ACTIVITY_INTENT";//通用的activity启动意图

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        if (getIsNeedStatusBarShade()) {
            StatusBarUtils.setStatusBarLightMode(this, Color.WHITE);
        }
        unBinder = ButterKnife.bind(this);
        mActivity = this;
        onViewCreated();
        ActivityCollector.getInstance().addActivity(this);
        initEventAndData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        unBinder.unbind();
    }

    protected void setToolBar(Toolbar toolBar, CharSequence title) {
        toolBar.setTitle(title);
        setSupportActionBar(toolBar);
        assert getSupportActionBar() != null;
    }

    /**
     * 状态栏白色问题，把系统文字改成黑的
     *
     * @return
     */
    protected boolean getIsNeedStatusBarShade() {
        return true;
    }

    /**
     * 初始化滚动圈，方便需要的界面调用
     * 直接通过跟视图添加滚动圈的方式
     */
    protected View progressView;

    private void initProgressView() {
        FrameLayout rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        progressView = LayoutInflater.from(this).inflate(R.layout.include_progress, null);
        progressView.setVisibility(View.GONE);
        rootView.addView(progressView);
        rootView.requestLayout();
    }

    public void showProgressView() {
        if (null != progressView) {
            progressView.setVisibility(View.VISIBLE);
        } else {
            initProgressView();
            if (null != progressView) {
                progressView.setVisibility(View.VISIBLE);
            }
        }
    }

    public void hideProgressView() {
        if (null != progressView) {
            progressView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressView.setVisibility(View.GONE);
                }
            }, 500);
        }
    }

    /**
     * 给textview 设置不为null的文本
     */
    protected void setUnNullText(TextView textView, String text) {
        if (textView != null && text != null && text.length() > 0
                && !text.equals("null") && !text.equals("NULL") && !text.equals("Null")) {
            textView.setText(text);
        }
    }

    protected void onViewCreated() {

    }

    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initEventAndData();
}


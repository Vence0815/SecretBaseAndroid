package com.renrun.secretbase_android.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.renrun.secretbase_android.R;
import com.renrun.secretbase_android.base.fragment.AbstractSimpleFragment;
import com.renrun.secretbase_android.ui.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by vence on 2018/6/10 15:54
 * 邮箱 ：vence0815@foxmail.com
 */
public class DynamicFragment extends AbstractSimpleFragment {
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dynamic;
    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }
}

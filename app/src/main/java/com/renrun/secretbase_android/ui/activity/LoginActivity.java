package com.renrun.secretbase_android.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.renrun.secretbase_android.R;
import com.renrun.secretbase_android.base.activity.BaseActivity;
import com.renrun.secretbase_android.dataCore.bean.LoginInfoBean;
import com.renrun.secretbase_android.mvp.contract.LoginContract;
import com.renrun.secretbase_android.mvp.presenter.LoginPresenter;
import com.renrun.secretbase_android.utils.DesManager;
import com.renrun.secretbase_android.utils.LogHelper;
import com.renrun.secretbase_android.utils.ToastHelper;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {


    @BindView(R.id.menu_tv)
    TextView menuTv;
    @BindView(R.id.toolbar_login)
    Toolbar toolbarLogin;
    @BindView(R.id.et_login_tel)
    EditText etLoginTel;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.et_login_identify_code)
    EditText etLoginIdentifyCode;
    @BindView(R.id.tv_login_send_identify_code)
    TextView tvLoginSendIdentifyCode;
    @BindView(R.id.ll_login_identify_layout)
    LinearLayout llLoginIdentifyLayout;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @OnClick({R.id.tv_login_send_identify_code, R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login_send_identify_code:
                break;
            case R.id.btn_login:
                String tel = etLoginTel.getText().toString();
                String pwd = etLoginPassword.getText().toString();

                long timeMillis = System.currentTimeMillis();

                Map<String, String> params = new HashMap<>();
                params.put("deviceType", "android");
                params.put("appVersion", "1.0");
                params.put("status", "2");
                params.put("phone", DesManager.encryptDES(tel, DesManager.getReqKey(timeMillis + "")));
                params.put("password", DesManager.encryptDES(pwd, DesManager.getReqKey(timeMillis + "")));
                params.put("verificationCode", "");
                params.put("requestId", timeMillis + "");

                mPresenter.login(params);
                break;
            case R.id.btn_register:
                break;
            default:
                break;
        }
    }


    @Override
    public void loginResult(LoginInfoBean loginInfoBean) {
        ToastHelper.successWithicon("登录成功啦--token---->" + loginInfoBean.getData().getToken());
    }
}

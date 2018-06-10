package com.renrun.secretbase_android;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.renrun.secretbase_android.base.activity.BaseActivity;
import com.renrun.secretbase_android.mvp.contract.MainContract;
import com.renrun.secretbase_android.mvp.presenter.MainPresenter;
import com.renrun.secretbase_android.ui.fragment.MyFragment;
import com.renrun.secretbase_android.ui.fragment.ChatFragment;
import com.renrun.secretbase_android.ui.fragment.DynamicFragment;
import com.renrun.secretbase_android.ui.fragment.MeetFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.rbtn_main_home)
    RadioButton mRbtnHome;
    @BindView(R.id.rl_main_home)
    RelativeLayout rlMainHome;
    @BindView(R.id.rbtn_main_circle)
    RadioButton mRbtnCircle;
    @BindView(R.id.rl_main_circle)
    RelativeLayout rlMainCircle;
    @BindView(R.id.iv_main_release)
    ImageView ivMainRelease;
    @BindView(R.id.rbtn_main_chat)
    RadioButton mRbtnChat;
    @BindView(R.id.tv_main_chat_unread)
    TextView tvMainChatUnread;
    @BindView(R.id.rl_main_chat)
    RelativeLayout rlMainChat;
    @BindView(R.id.rbtn_main_my)
    RadioButton mRbtnMy;
    @BindView(R.id.rl_main_my)
    RelativeLayout rlMainMy;
    @BindView(R.id.welcome_container)
    LinearLayout welcomeContainer;

    private List<Fragment> mFragmentList = new ArrayList<>();
    private DynamicFragment mDynamicFragment;
    private MeetFragment mMeetFragment;
    private ChatFragment mChatFragment;
    private MyFragment myFragment;

    @Override
    protected int getLayoutId() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        initView();
    }

    private void initView() {
        mDynamicFragment = new DynamicFragment();
        mMeetFragment = new MeetFragment();
        mChatFragment = new ChatFragment();
        myFragment = new MyFragment();

        mFragmentList.add(mDynamicFragment);
        mFragmentList.add(mMeetFragment);
        mFragmentList.add(mChatFragment);
        mFragmentList.add(myFragment);

        // 初始化Fragment
        FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
        fragTrans.add(R.id.fl_main, mFragmentList.get(0));
        fragTrans.add(R.id.fl_main, mFragmentList.get(1));
        fragTrans.add(R.id.fl_main, mFragmentList.get(2));
        fragTrans.add(R.id.fl_main, mFragmentList.get(3));
        fragTrans.commit();
        showFragment(0);
        switchTab(0);
    }



    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @OnClick({R.id.rl_main_home, R.id.rl_main_circle, R.id.iv_main_release, R.id.rl_main_chat, R.id.rl_main_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_main_home:
                showFragment(0);
                switchTab(0);
                break;
            case R.id.rl_main_circle:
                showFragment(1);
                switchTab(1);
                break;
            case R.id.iv_main_release:
                break;
            case R.id.rl_main_chat:
                showFragment(2);
                switchTab(2);
                break;
            case R.id.rl_main_my:
                showFragment(3);
                switchTab(3);
                break;
            default:
                break;
        }
    }


    /**
     * 显示Fragment
     *
     * @param index 下标
     */
    private void showFragment(int index) {
        int size = mFragmentList.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = mFragmentList.get(i);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (index == i) {
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }
            ft.commit();
        }
    }

    /**
     * 切换底部tab
     *
     * @param index
     */
    private void switchTab(int index) {
        mRbtnHome.setChecked(false);
        mRbtnCircle.setChecked(false);
        mRbtnChat.setChecked(false);
        mRbtnMy.setChecked(false);
        if (index == 0) {
            mRbtnHome.setChecked(true);
        } else if (index == 1) {
            mRbtnCircle.setChecked(true);
        } else if (index == 2) {
            mRbtnChat.setChecked(true);
        } else if (index == 3) {
            mRbtnMy.setChecked(true);
        }
    }
}

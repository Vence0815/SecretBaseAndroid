package com.renrun.secretbase_android.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.renrun.secretbase_android.R;
import com.renrun.secretbase_android.app.MyApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by vence on 2018/4/27 16:29
 * 邮箱 ：vence0815@foxmail.com
 */
public class CommonUtils {
    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    /**
     * Show message
     *
     * @param activity Activity
     * @param msg      message
     */
    public static void showSnackMessage(Activity activity, String msg) {
        Snackbar snackbar = Snackbar.make(activity.getWindow().getDecorView(), msg, Snackbar.LENGTH_SHORT);
        View view = snackbar.getView();
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(ContextCompat.getColor(activity, R.color.white));
        snackbar.show();
    }


    /**
     * 获取渠道信息
     *
     * @return 对应的渠道的值
     */
    public static String getChannel() {
        return getAppMetaData("UMENG_CHANNEL");
    }


    /**
     * 获取application中指定的meta-data
     *
     * @return 如果没有获取成功(没有对应值 ， 或者异常)，则返回值为空
     */
    private static String getAppMetaData(String key) {
        String resultData = "";
        try {
            PackageManager packageManager = MyApplication.getInstance().getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(MyApplication.getInstance().getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        if (applicationInfo.metaData.getString(key) != null) {
                            resultData = applicationInfo.metaData.getString(key);
                        }
                    }
                }

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return resultData;
    }

    /**
     * 大陆号码或香港号码均可
     */
    public static boolean isPhoneLegal(String str) throws PatternSyntaxException {
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
    private static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 香港手机号码8位数，5|6|8|9开头+7位任意数
     */
    private static boolean isHKPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^(5|6|8|9)\\d{7}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static int getStatusHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            int statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
            return statusBarHeight;
        }
        return 0;
    }

    public static String getAssetsString(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    context.getAssets().open(fileName), "UTF-8"));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Error", e.getMessage());
        }
        return stringBuilder.toString();
    }

    /**
     * 判断string是否可以转为int
     *
     * @param str String
     * @return
     */
    public static boolean canParseInt(String str) {
        if (str == null) {
            //验证是否为空
            return false;
        }
        //使用正则表达式判断该字符串是否为数字，第一个\是转义符，\d+表示匹配1个或  //多个连续数字，"+"和"*"类似，"*"表示0个或多个
        return str.matches("\\d+");
    }

    /**
     *从身份证中获取年龄
     * @param IDCard 身份证序列号，身份证只能为15 或者 18位
     * @return
     */
    public static int getAgeFromIDCard(String IDCard) {
        int leh = IDCard.length();
        if(leh != 15 && leh!= 18){
            return -1;
        }
        String dates;
        if (leh == 18) {
            dates = IDCard.substring(6, 10);
        } else {
            dates = IDCard.substring(6, 8);
            dates = "19" + dates;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        String year = df.format(new Date());
        int u = Integer.parseInt(year) - Integer.parseInt(dates);
        return u;
    }


}

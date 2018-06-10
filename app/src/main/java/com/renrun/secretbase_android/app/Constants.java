package com.renrun.secretbase_android.app;

import java.io.File;

/**
 * Created by vence on 2018/4/27 16:27
 * 邮箱 ：vence0815@foxmail.com
 */
public class Constants {

    /**
     * base url
     */
    public static final String preUrl = "http://yangdailin.zicp.io:41235/";

    public static final String NAMESPACE = "http://yangdailin.zicp.io:41235/";


    /**
     * Path
     */
    public static final String PATH_DATA = MyApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";


}

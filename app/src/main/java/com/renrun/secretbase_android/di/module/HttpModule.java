package com.renrun.secretbase_android.di.module;


import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.renrun.secretbase_android.BuildConfig;
import com.renrun.secretbase_android.app.Constants;
import com.renrun.secretbase_android.dataCore.http.api.Apis;
import com.renrun.secretbase_android.dataCore.http.interceptor.BasicParamsInterceptor;
import com.renrun.secretbase_android.dataCore.http.interceptor.VHttpLoggingInterceptor;
import com.renrun.secretbase_android.di.qualifier.MyAppUrl;
import com.renrun.secretbase_android.utils.CommonUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vence on 2018/4/27 14:55
 * 邮箱 ：vence0815@foxmail.com
 */
@Module
public class HttpModule {
    @Singleton
    @Provides
    Apis provideGeeksApi(@MyAppUrl Retrofit retrofit) {
        return retrofit.create(Apis.class);
        //使用了代理
//        return new HttpProxy().newProxyInstance(retrofit.create(Apis.class));
    }

    @Singleton
    @Provides
    @MyAppUrl
        //这个MyAppUrl是为了限定域，区分不同地方使用的Retrofit对象
    Retrofit provideGeeksRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, Constants.NAMESPACE);
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new VHttpLoggingInterceptor(VHttpLoggingInterceptor.Level.RR));
        }
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = chain -> {
            Request request = chain.request();
            if (!CommonUtils.isNetworkConnected()) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            if (CommonUtils.isNetworkConnected()) {
                int maxAge = 0;
                // 有网络时, 不缓存, 最大保存时长为0
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
//                        .header("content-type", "application/json")
                        .removeHeader("Pragma")
                        .build();
            } else {
                // 无网络时，设置超时为4周
                int maxStale = 60 * 60 * 24 * 28;
                response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build();
            }
            return response;
        };

        BasicParamsInterceptor basicParamsInterceptor = new BasicParamsInterceptor.Builder()
                .addQueryParam("os", "Android")
                .addQueryParam("channel", CommonUtils.getChannel())
                .addHeaderParam("Content-Type","application/json")
                .build();

        //设置基础的内容每个接口默认带上的
        builder.addInterceptor(basicParamsInterceptor);
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);
        //添加Stetho
        builder.addNetworkInterceptor(new StethoInterceptor());
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}

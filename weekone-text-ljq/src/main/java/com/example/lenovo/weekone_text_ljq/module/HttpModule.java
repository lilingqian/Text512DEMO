package com.example.lenovo.weekone_text_ljq.module;




import com.example.lenovo.weekone_text_ljq.net.JokesApi;
import com.example.lenovo.weekone_text_ljq.net.JokesApiService;
import com.example.lenovo.weekone_text_ljq.net.MyInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {

    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS);
    }


    @Provides
    JokesApi provideJokesApi(OkHttpClient.Builder builder){

        builder.addInterceptor(new MyInterceptor());//添加拦截器

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")//公共请求头
                .addConverterFactory(GsonConverterFactory.create())//关联gson
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//关联rxjava
                .build();

        JokesApiService jokesApiService = retrofit.create(JokesApiService.class);

        return JokesApi.getJokesApi(jokesApiService);
    }
}

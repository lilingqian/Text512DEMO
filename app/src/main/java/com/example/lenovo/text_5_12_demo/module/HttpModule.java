package com.example.lenovo.text_5_12_demo.module;


import com.example.lenovo.text_5_12_demo.net.JokesApi;
import com.example.lenovo.text_5_12_demo.net.JokesApiService;
import com.example.lenovo.text_5_12_demo.net.MyInterceptor;

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
    OkHttpClient.Builder provideOkHttpClientBuilder(){

        return  new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS);

    }

    @Provides
    JokesApi provideJokesApi(OkHttpClient.Builder builder) {
         builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        JokesApiService jokesApiService = retrofit.create(JokesApiService.class);
        return JokesApi.getJokesApi(jokesApiService);

    }
}

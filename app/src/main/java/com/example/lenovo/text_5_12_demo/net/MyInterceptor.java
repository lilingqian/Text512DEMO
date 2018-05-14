package com.example.lenovo.text_5_12_demo.net;



import java.io.IOException;


import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 拦截器
 * */
public class MyInterceptor implements Interceptor {

    private Response response;

    @Override
    public Response intercept(Chain chain) throws IOException {

        //获取原始的request请求
        Request originalRequest=chain.request();
        //判断是get请求还是post
        String method= originalRequest.method();
        if ("GET".equals(method)) {

            HttpUrl httpUrl = originalRequest.url()
                    .newBuilder()
                    //添加公共的请求参数
                    .addQueryParameter("source", "android")
                    .addQueryParameter("appVersion", "101")
                    .build();

            Request request = new Request.Builder()
                    .url(httpUrl)
                    .build();

            //发送完成后的请求
            response = chain.proceed(request);


        }else {
            RequestBody requestBody=originalRequest.body();
            if (requestBody instanceof FormBody){
                FormBody.Builder builder=new FormBody.Builder();

                FormBody   originalformBody= (FormBody) originalRequest.body();

                for (int i=0;i<originalformBody.size();i++){

                    builder.add(originalformBody.name(i),originalformBody.value(i));

                }

                builder.add("source","android");
                builder.add("appVersion","101");
                FormBody formBody=builder.build();
                Request request=originalRequest.newBuilder().post(formBody).build();
                response=chain.proceed(request);

            }
        }

        return response;
    }
}

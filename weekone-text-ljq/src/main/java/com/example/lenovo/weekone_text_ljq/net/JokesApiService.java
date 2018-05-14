package com.example.lenovo.weekone_text_ljq.net;

import com.example.lenovo.weekone_text_ljq.bean.DuanZiBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JokesApiService {

    //https://www.zhaoapi.cn/quarter/getJokes?source=android&appVersion=101
    @FormUrlEncoded
    @POST("quarter/getJokes")
     Observable<DuanZiBean > getJokes(@Field("page") String page);

}

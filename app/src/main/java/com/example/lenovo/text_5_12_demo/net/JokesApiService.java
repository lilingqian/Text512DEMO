package com.example.lenovo.text_5_12_demo.net;

import com.example.lenovo.text_5_12_demo.bean.DuanZiBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JokesApiService {


  @FormUrlEncoded
   @POST("quarter/getJokes")
   Observable<DuanZiBean> getJokes(@Field("page") String page);


}

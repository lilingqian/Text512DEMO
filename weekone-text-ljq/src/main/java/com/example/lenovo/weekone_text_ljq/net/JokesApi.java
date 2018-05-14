package com.example.lenovo.weekone_text_ljq.net;

import com.example.lenovo.weekone_text_ljq.bean.DuanZiBean;

import io.reactivex.Observable;

public class JokesApi {

    private  static JokesApi jokesApi;



    private JokesApiService jokesApiService;

    //有参构造

    private JokesApi(JokesApiService jokesApiService){

        this.jokesApiService=jokesApiService;

    }

    //单利模式
    public  static JokesApi getJokesApi(JokesApiService jokesApiService){
        if (jokesApi==null){
          jokesApi=  new JokesApi(jokesApiService);

        }
        return  jokesApi;
    }


    //返回这个类
    public Observable<DuanZiBean> getJokes(String page) {
     return  jokesApiService.getJokes(page);
    }



}


package com.example.lenovo.text_5_12_demo.net;

import com.example.lenovo.text_5_12_demo.bean.DuanZiBean;

import io.reactivex.Observable;


public class JokesApi {


    private static  JokesApi jokesApi;
    private JokesApiService jokesApiService;

    private  JokesApi(JokesApiService jokesApiService){

        this.jokesApiService=jokesApiService;
    }

    public  static  JokesApi getJokesApi(JokesApiService jokesApiService){

        if (jokesApiService ==null){

            jokesApi =new JokesApi(jokesApiService);

        }
            return jokesApi;
    }



    public Observable<DuanZiBean> getJokes(String page)
    {

         return  jokesApiService.getJokes(page);
    }
}

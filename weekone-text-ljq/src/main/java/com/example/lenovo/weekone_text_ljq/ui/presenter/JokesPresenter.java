package com.example.lenovo.weekone_text_ljq.ui.presenter;

import com.example.lenovo.weekone_text_ljq.bean.DuanZiBean;
import com.example.lenovo.weekone_text_ljq.net.JokesApi;
import com.example.lenovo.weekone_text_ljq.ui.base.BasePresenter;
import com.example.lenovo.weekone_text_ljq.ui.contract.JokesContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class JokesPresenter  extends BasePresenter<JokesContract.view>implements JokesContract.presenter{

    private JokesApi jokesApi;


    @Inject
    public JokesPresenter (JokesApi jokesApi){

        this.jokesApi=jokesApi;

    }
    @Override
    public void getJokes(String page) {


        jokesApi.getJokes(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<DuanZiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    //数据请求成功方法
                    @Override
                    public void onNext(DuanZiBean duanZiBean) {

                        mView.onSunccess(duanZiBean);
                    }

                    //失败的方法
                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

package com.example.lenovo.text_5_12_demo.ui.presenter;

import com.example.lenovo.text_5_12_demo.bean.DuanZiBean;
import com.example.lenovo.text_5_12_demo.net.JokesApi;
import com.example.lenovo.text_5_12_demo.ui.base.BasePresenter;
import com.example.lenovo.text_5_12_demo.ui.contract.JokesContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class JokesPresenter extends BasePresenter<JokesContract.View> implements JokesContract.presenter{



    private JokesApi jokesApi;

    @Inject
    public  JokesPresenter(JokesApi jokesApi){
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

                    @Override
                    public void onNext(DuanZiBean duanZiBean) {

                        mView.onSuccess(duanZiBean);
                    }

                    @Override
                    public void onError(Throwable e) {


                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

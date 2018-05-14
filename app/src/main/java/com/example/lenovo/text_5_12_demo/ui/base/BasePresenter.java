package com.example.lenovo.text_5_12_demo.ui.base;


import com.example.lenovo.text_5_12_demo.ui.base.BaseContract;

public class BasePresenter<T extends BaseContract.BaseView> implements  BaseContract.BasePresenter <T> {


    protected T mView;


    @Override
    public void attchView(T view) {

        //判断是否为空
        if (view!=null){
            mView=view;
        }

    }

    //解绑
    @Override
    public void detachView() {
        if (mView!=null){
            mView=null;
        }
    }
}

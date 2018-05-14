package com.example.lenovo.weekone_text_ljq.ui.base;

import com.example.lenovo.weekone_text_ljq.ui.base.BaseContract;

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {


    //定义子类可以用的view
    protected T mView;

    //绑定view
    @Override
    public void attchView(T view) {

        if (view!=null){
            mView=view;
        }
    }

    //解绑view
    @Override
    public void detachView() {
        if (mView!=null){
            mView=null;
        }
    }
}

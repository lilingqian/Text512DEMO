package com.example.lenovo.weekone_text_ljq.ui.base;

//封装了p层 v层
public interface BaseContract {

    interface  BasePresenter<T extends  BaseView> {

        void attchView(T view );

        void  detachView();

    }

    interface  BaseView{

        void showLoading();

        void shibai();


    }
}

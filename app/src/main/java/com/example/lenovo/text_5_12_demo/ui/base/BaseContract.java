package com.example.lenovo.text_5_12_demo.ui.base;

public interface BaseContract {

  interface   BasePresenter <T extends  BaseView>   {

    void attchView(T view);
    void  detachView();

    }

    interface  BaseView{
    void showLoading();

    }

}

package com.example.lenovo.text_5_12_demo.ui.contract;

import com.example.lenovo.text_5_12_demo.bean.DuanZiBean;
import com.example.lenovo.text_5_12_demo.ui.base.BaseContract;

public interface JokesContract {

    interface  View extends BaseContract.BaseView{
        void onSuccess(DuanZiBean duanZiBean);
    }

    interface presenter extends BaseContract.BasePresenter<View>{
        void  getJokes(String page);

    }
}

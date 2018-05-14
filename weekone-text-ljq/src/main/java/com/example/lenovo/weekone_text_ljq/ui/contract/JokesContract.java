package com.example.lenovo.weekone_text_ljq.ui.contract;

import com.example.lenovo.weekone_text_ljq.bean.DuanZiBean;
import com.example.lenovo.weekone_text_ljq.ui.base.BaseContract;

public interface JokesContract {


    interface view extends BaseContract.BaseView{
        void onSunccess(DuanZiBean duanZiBean);
    }


    interface presenter extends BaseContract.BasePresenter <view>{

        void  getJokes(String page);
    }

}

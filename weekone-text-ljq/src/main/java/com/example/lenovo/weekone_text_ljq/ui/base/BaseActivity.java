package com.example.lenovo.weekone_text_ljq.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.weekone_text_ljq.inter.IBase;

import javax.inject.Inject;


public abstract class BaseActivity<T  extends BaseContract.BasePresenter> extends AppCompatActivity implements BaseContract.BaseView ,IBase{

    //传一个presenter


    @Inject
    protected  T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();

        if (mPresenter!=null){}
        mPresenter.attchView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }

    //展示
    @Override
    public void showLoading() {

    }
}

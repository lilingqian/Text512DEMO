package com.example.lenovo.weekone_text_ljq;

import android.os.Bundle;

import com.example.lenovo.weekone_text_ljq.bean.DuanZiBean;
import com.example.lenovo.weekone_text_ljq.component.DaggerHttpComponent;
import com.example.lenovo.weekone_text_ljq.ui.base.BaseActivity;
import com.example.lenovo.weekone_text_ljq.ui.contract.JokesContract;
import com.example.lenovo.weekone_text_ljq.ui.presenter.JokesPresenter;

public class MainActivity extends BaseActivity<JokesPresenter> implements JokesContract.view {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.getJokes("1");

    }


    @Override
    public void onSunccess(DuanZiBean duanZiBean) {


    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    //注入actvity
    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }


    @Override
    public void shibai() {

    }
}

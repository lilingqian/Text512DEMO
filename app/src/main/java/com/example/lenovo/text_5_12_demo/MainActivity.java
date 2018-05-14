package com.example.lenovo.text_5_12_demo;


import android.os.Bundle;
import com.example.lenovo.text_5_12_demo.bean.DuanZiBean;
import com.example.lenovo.text_5_12_demo.component.DaggerHttpComponent;
import com.example.lenovo.text_5_12_demo.ui.base.BaseActivity;
import com.example.lenovo.text_5_12_demo.ui.contract.JokesContract;
import com.example.lenovo.text_5_12_demo.ui.presenter.JokesPresenter;


public class MainActivity extends BaseActivity<JokesPresenter> implements JokesContract.View {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getJokes("1");

    }

    @Override
    public void onSuccess(DuanZiBean duanZiBean) {


    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {

        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }
}

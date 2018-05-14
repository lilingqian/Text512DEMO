package com.example.lenovo.text_5_12_demo.component;

import com.example.lenovo.text_5_12_demo.MainActivity;
import com.example.lenovo.text_5_12_demo.module.HttpModule;

import dagger.Component;


@Component(modules = HttpModule.class)
public interface HttpComponent {


    void inject(MainActivity mainActivity);

}

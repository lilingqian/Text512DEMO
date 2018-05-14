package com.example.lenovo.weekone_text_ljq.component;

import com.example.lenovo.weekone_text_ljq.MainActivity;
import com.example.lenovo.weekone_text_ljq.module.HttpModule;

import dagger.Component;

@Component(modules = HttpModule.class)//指定要关联的moduler
public interface HttpComponent {

    void inject(MainActivity mainActivity);

}

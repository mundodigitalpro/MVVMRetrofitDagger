package com.example.mvvmretrofitdagger;

import android.app.Application;

import com.example.mvvmretrofitdagger.di.DaggerRetroComponent;
import com.example.mvvmretrofitdagger.di.RetroComponent;
import com.example.mvvmretrofitdagger.di.RetroModule;

public class MyApplication extends Application {

    private RetroComponent retroComponent;

    @Override
    public void onCreate(){
        super.onCreate();

        retroComponent = DaggerRetroComponent.builder()
                .retroModule(new RetroModule())
                .build();
    }

    public RetroComponent getRetroComponent(){
        return retroComponent;
    }
}

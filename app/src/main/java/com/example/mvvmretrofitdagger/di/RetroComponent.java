package com.example.mvvmretrofitdagger.di;
import com.example.mvvmretrofitdagger.MainActivityViewModel;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {RetroModule.class})
public interface RetroComponent {
    public void inject(MainActivityViewModel mainActivityViewModel);
}

package com.example.mvvmretrofitdagger;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmretrofitdagger.di.RetroServiceInterface;
import com.example.mvvmretrofitdagger.model.RecyclerList;
import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {


    @Inject
    RetroServiceInterface mService;
    private MutableLiveData<RecyclerList> liveDataList;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        ((MyApplication)application).getRetroComponent().inject(MainActivityViewModel.this);
        liveDataList = new MutableLiveData<>();
    }

    public MutableLiveData<RecyclerList> getRecyclerListObserver(){

        return liveDataList;
    }

    public void makeApiCall(){
        Call<RecyclerList> call = mService.getDataFromAPI("spain");
        call.enqueue(new Callback<RecyclerList>() {
            @Override
            public void onResponse(Call<RecyclerList> call, Response<RecyclerList> response) {
                if(response.isSuccessful()){
                    liveDataList.postValue(response.body());
                }else{
                    liveDataList.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<RecyclerList> call, Throwable t) {

            }
        });

    }
}

package com.essejose.androidrestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.essejose.androidrestapp.adapter.AndroidAdpter;
import com.essejose.androidrestapp.api.APIUtils;
import com.essejose.androidrestapp.api.AndroidAPI;
import com.essejose.androidrestapp.model.Android;
import com.essejose.androidrestapp.model.ResponseAndroid;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAndroids;
    private AndroidAdpter androidAdpter;
    private AndroidAPI androidAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAndroids = (RecyclerView) findViewById(R.id.rvAndroids);

        androidAdpter = new AndroidAdpter( new ArrayList<Android>());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvAndroids.setLayoutManager(layoutManager);
        rvAndroids.setAdapter(androidAdpter);
        rvAndroids.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration
                = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);

        rvAndroids.addItemDecoration(itemDecoration);

        carregaDados();

    }

    private  void carregaDados(){
        androidAPI = APIUtils.getAndroidAPIVersion();

        androidAPI.getVersoes().enqueue(new Callback<ResponseAndroid>() {
            @Override
            public void onResponse(Call<ResponseAndroid> call, Response<ResponseAndroid> response) {
                if(response.isSuccessful()){

                    androidAdpter.update(
                            response
                                    .body()
                                    .getAndroids());
                }
            }

            @Override
            public void onFailure(Call<ResponseAndroid> call, Throwable t) {

            }
        });
    }
}

package com.shakil.api_practice;


import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.RecycleviewId);

        apiInterface=RetrofitInstance.getRetrofit().create(ApiInterface.class);
        apiInterface.getposts().enqueue(new Callback<List<PostPojo>>() {
            @Override
            public void onResponse(Call<List<PostPojo>> call, Response<List<PostPojo>> response) {
                if(response.body().size()>0){
                    List<PostPojo> postPojos =response.body();
                    RecycleAdapter recycleAdapter = new RecycleAdapter(MainActivity.this,postPojos);
                    LinearLayoutManager linearLayoutManager= new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(recycleAdapter);
                    Toast.makeText(MainActivity.this,"Toast is not empty",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(MainActivity.this,"Toast is empty",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<PostPojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });


    }
}
package com.maad.youtube.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.maad.youtube.R;
import com.maad.youtube.data.Callable;
import com.maad.youtube.data.Constants;
import com.maad.youtube.data.CustomAdapter;
import com.maad.youtube.data.channel_data.YouTubeChannelModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.pb);
        RecyclerView recyclerView = findViewById(R.id.rv_channel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<String> channelIDs = new ArrayList<>();
        channelIDs.add("UCnDAXfhnL5j-KhHc1KhvXHw,");
        channelIDs.add("UCOCLXisw46INr_6RCyPGpkw,");
        channelIDs.add("UC_x5XG1OV2P6uZZ5FSM9Ttw,");
        channelIDs.add("UCVHFbqXqoYvEWM1Ddxl0QDg,");
        channelIDs.add("UCFA8zDjl3Q7NDDxuoEc1ouQ");
        StringBuilder modifiedChannelIDs = new StringBuilder();

        for (String channel : channelIDs)
            modifiedChannelIDs.append(channel);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Callable callableInterface = retrofit.create(Callable.class);
        Call<YouTubeChannelModel> channelCall = callableInterface.getChannels(modifiedChannelIDs);
        channelCall.enqueue(new Callback<YouTubeChannelModel>() {
            @Override
            public void onResponse(Call<YouTubeChannelModel> call, Response<YouTubeChannelModel> response) {
                progressBar.setVisibility(View.GONE);
                //Log.d("jsonResponse", response.body().getChannelItems().get(0).getSnippetModel().getChannelTitle());
                ArrayList<YouTubeChannelModel.ChannelItemModel> channelModels = response.body().getChannelItems();
                CustomAdapter adapter = new CustomAdapter(MainActivity.this, channelModels);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<YouTubeChannelModel> call, Throwable t) {
                Log.d("jsonResponse", "Error: " + t.getMessage());
            }
        });


    }
}

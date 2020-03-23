package com.maad.youtube.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.maad.youtube.R;
import com.maad.youtube.data.InternetConnection;
import com.maad.youtube.data.channel_data.ChannelNetworkManager;
import com.maad.youtube.data.channel_data.FetchingChannel;
import com.maad.youtube.data.channel_data.YouTubeChannelModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.pb);
        recyclerView = findViewById(R.id.rv_channel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        boolean isConnected = new InternetConnection().checkInternetConnection(this);
        if (isConnected)
            makeChannelNetworkCall();
        else
            Toast.makeText(this, R.string.check_internet, Toast.LENGTH_SHORT).show();
    }

    private void makeChannelNetworkCall() {
        ChannelNetworkManager channelNetworkManager = new ChannelNetworkManager();
        channelNetworkManager.loadChannels(new FetchingChannel() {
            @Override
            public void onSuccess(YouTubeChannelModel channelModel) {
                progressBar.setVisibility(View.GONE);
                //Log.d("jsonResponse", response.body().getChannelItems().get(0).getSnippetModel().getChannelTitle());
                ArrayList<YouTubeChannelModel.ChannelItemModel> channelModels = channelModel.getChannelItems();
                CustomAdapter adapter = new CustomAdapter(MainActivity.this, channelModels);
                recyclerView.setAdapter(adapter);
                adapter.setOnClickListener(view -> {
                    Log.d("jsonResponse", "Subscribe button is clicked");
                });
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("jsonResponse", "Error: " + t.getMessage());
            }
        });
    }
}

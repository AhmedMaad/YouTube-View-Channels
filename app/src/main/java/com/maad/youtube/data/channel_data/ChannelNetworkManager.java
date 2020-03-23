package com.maad.youtube.data.channel_data;

import com.maad.youtube.data.Callable;
import com.maad.youtube.data.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChannelNetworkManager {

    public void loadChannels(FetchingChannel fetchingChannel) {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Callable callableInterface = retrofit.create(Callable.class);
        Call<YouTubeChannelModel> channelCall = callableInterface
                .getChannels(new YouTubeChannelModel().getChannelsID());

        channelCall.enqueue(new Callback<YouTubeChannelModel>() {
            @Override
            public void onResponse(Call<YouTubeChannelModel> call, Response<YouTubeChannelModel> response) {
                fetchingChannel.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<YouTubeChannelModel> call, Throwable t) {
                fetchingChannel.onFailure(t);
            }
        });

    }

}

package com.maad.youtube.data;

import com.maad.youtube.data.channel_data.YouTubeChannelModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Callable {

    //TODO: Add your own API key for the *key* query parameter
    @GET("channels?key=&part=snippet")
    Call<YouTubeChannelModel> getChannels(@Query("id") StringBuilder channelIDs);

}

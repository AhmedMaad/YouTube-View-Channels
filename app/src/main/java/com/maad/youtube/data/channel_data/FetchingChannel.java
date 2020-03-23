package com.maad.youtube.data.channel_data;

import com.maad.youtube.data.channel_data.YouTubeChannelModel;

import java.util.ArrayList;

public interface FetchingChannel {
    void onSuccess(YouTubeChannelModel channelModel);
    void onFailure (Throwable t);
}

package com.maad.youtube.data.channel_data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class YouTubeChannelModel {

    @SerializedName("items")
    private ArrayList<ChannelItemModel> channelItems;

    public ArrayList<ChannelItemModel> getChannelItems() {
        return channelItems;
    }

    public class ChannelItemModel {

        @SerializedName("snippet")
        private SnippetModel snippetModel;

        public SnippetModel getSnippetModel() {
            return snippetModel;
        }
    }

}

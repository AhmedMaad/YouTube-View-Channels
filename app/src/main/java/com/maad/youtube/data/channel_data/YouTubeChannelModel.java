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

    public StringBuilder getChannelsID() {
        ArrayList<String> channelIDs = new ArrayList<>();
        channelIDs.add("UCnDAXfhnL5j-KhHc1KhvXHw,");
        channelIDs.add("UCOCLXisw46INr_6RCyPGpkw,");
        channelIDs.add("UC_x5XG1OV2P6uZZ5FSM9Ttw,");
        channelIDs.add("UCVHFbqXqoYvEWM1Ddxl0QDg,");
        channelIDs.add("UCFA8zDjl3Q7NDDxuoEc1ouQ");
        StringBuilder modifiedChannelIDs = new StringBuilder();
        //Making the list of channels in one String to be sent as a query parameter
        for (String channel : channelIDs)
            modifiedChannelIDs.append(channel);

        return modifiedChannelIDs;
    }

}

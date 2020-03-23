package com.maad.youtube.data.channel_data;

import com.google.gson.annotations.SerializedName;

public class SnippetModel {

    @SerializedName("title")
    private String channelTitle;
    @SerializedName("thumbnails")
    private ThumbnailsModel thumbnails;

    public String getChannelTitle() {
        return channelTitle;
    }

    public ThumbnailsModel getThumbnails() {
        return thumbnails;
    }

    public class ThumbnailsModel {

        @SerializedName("high")
        private HighResolutionModel highResolutionModel;

        public HighResolutionModel getHighResolutionModel() {
            return highResolutionModel;
        }

        public class HighResolutionModel {
            @SerializedName("url")
            private String thumbnailURL;

            public String getThumbnailURL() {
                return thumbnailURL;
            }
        }

    }

}

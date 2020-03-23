package com.maad.youtube.data;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.maad.youtube.R;
import com.maad.youtube.data.channel_data.YouTubeChannelModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ItemViewHolder> {

    private Activity activity;
    private ArrayList<YouTubeChannelModel.ChannelItemModel> channelModels;

    public CustomAdapter(Activity activity, ArrayList<YouTubeChannelModel.ChannelItemModel> channelModels) {
        this.activity = activity;
        this.channelModels = channelModels;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.channel_list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.channelNameTV.setText(channelModels.get(position).getSnippetModel().getChannelTitle());
        String thumbnailURL = channelModels.get(position).getSnippetModel().getThumbnails()
                .getHighResolutionModel().getThumbnailURL();
        Glide
                .with(activity)
                .load(thumbnailURL)
                .into(holder.channelThumbnailIV);
    }

    @Override
    public int getItemCount() {
        return channelModels.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView channelNameTV;
        private ImageView channelThumbnailIV;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            channelNameTV = itemView.findViewById(R.id.tv_channel);
            channelThumbnailIV = itemView.findViewById(R.id.iv_channel);
        }
    }
}

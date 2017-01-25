package com.example.sandeep.changepins;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sandeep_chi on 11/25/2016.
 */

public class RCVStoryAdapter extends RecyclerView.Adapter<RCVStoryAdapter.ViewHolder> {

    Context context;
    ArrayList<Story> storyList;

    public RCVStoryAdapter(Context context, ArrayList<Story> storyList) {
        this.context = context;
        this.storyList = storyList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, publisher;
        ImageView options, image;
        CardView cardStory;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvCardTitle);
            publisher = (TextView) itemView.findViewById(R.id.tvPublisherName);
            options = (ImageView) itemView.findViewById(R.id.ivCardOptions);
            image = (ImageView) itemView.findViewById(R.id.ivCardImage);
            cardStory = (CardView) itemView;
        }
    }

    @Override
    public RCVStoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_story, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RCVStoryAdapter.ViewHolder holder, final int position) {

        final Story story = storyList.get(position);

        holder.title.setText(story.getTitle());

        setRandomImage(holder,position);

        holder.cardStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (story.getStoryType() == 1) {
                    Intent intent = new Intent(context, StoryOne.class);
                    intent.putExtra("title", story.getTitle());
                    intent.putExtra("content", story.getContent());
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, StoryTwo.class);
                    intent.putExtra("title", story.getTitle());
                    intent.putExtra("content", story.getContent());
                    context.startActivity(intent);
                }
            }
        });

        holder.publisher.setText(story.getPublisher());
        holder.options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setItems(R.array.story_options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0://Share
                                Toast.makeText(context, "Share " + position, Toast.LENGTH_SHORT).show();
                                break;
                            case 1://Delete
                                Toast.makeText(context, "Delete " + position, Toast.LENGTH_SHORT).show();
                                break;
                            case 2://Report
                                Toast.makeText(context, "Report " + position, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public void setRandomImage(RCVStoryAdapter.ViewHolder holder, int position){
        switch (position%6){
            case 0:
                holder.image.setImageResource(R.drawable.eunoia2);
                break;
            case 1:
                holder.image.setImageResource(R.drawable.eunoia3);
                break;
            case 2:
                holder.image.setImageResource(R.drawable.eunoia4);
                break;
            case 3:
                holder.image.setImageResource(R.drawable.eunoia5);
                break;
            case 4:
                holder.image.setImageResource(R.drawable.test_image);
                break;
            case 5:
                holder.image.setImageResource(R.drawable.eunoia6);
                break;
        }
    }
}
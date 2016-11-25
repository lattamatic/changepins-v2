package com.example.sandeep.changepins;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sandeep on 25/11/16.
 */

public class StoriesFragment extends Fragment {

    RecyclerView rcvStories;
    RecyclerView.Adapter rcvAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Story> storyList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_stories,container,false);
        rcvStories = (RecyclerView) view.findViewById(R.id.rcv_stories);

        layoutManager = new LinearLayoutManager(getActivity());
        rcvStories.setLayoutManager(layoutManager);

        rcvAdapter = new RCVAdapter();
        rcvStories.setAdapter(rcvAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Testing purpose written code..to be removed
        storyList = new ArrayList<Story>();
        for(int i=1;i<6;i++){
            storyList.add(new Story(i%2, "Title "+ i, "This is the content for story " + i + ". Kindly note that this story is of type " + i%2));
        }
    }

    public class RCVAdapter extends RecyclerView.Adapter<RCVAdapter.ViewHolder>{

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView title, place;
            ImageView options, image;
            CardView cardStory;

            public ViewHolder(View itemView) {
                super(itemView);
                title = (TextView) itemView.findViewById(R.id.tvCardTitle);
                place = (TextView) itemView.findViewById(R.id.tvCardPlace);
                options = (ImageView) itemView.findViewById(R.id.ivCardOptions);
                image = (ImageView) itemView.findViewById(R.id.ivCardImage);

                cardStory = (CardView) itemView;

            }
        }

        @Override
        public RCVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_story_one,parent,false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RCVAdapter.ViewHolder holder, final int position) {
            holder.title.setText(storyList.get(position).getTitle());
            holder.place.setText(storyList.get(position).getContent());
            holder.cardStory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(storyList.get(position).getStoryType()==1){
                        Intent intent = new Intent(getActivity(),StoryOne.class);
                        intent.putExtra("title",storyList.get(position).getTitle());
                        intent.putExtra("content",storyList.get(position).getContent());
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(getActivity(),StoryTwo.class);
                        intent.putExtra("title",storyList.get(position).getTitle());
                        intent.putExtra("content",storyList.get(position).getContent());
                        startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return 5;
        }

    }
}

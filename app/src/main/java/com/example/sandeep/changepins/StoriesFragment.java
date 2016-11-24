package com.example.sandeep.changepins;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sandeep on 25/11/16.
 */

public class StoriesFragment extends Fragment {

    RecyclerView rcvStories;
    RecyclerView.Adapter rcvAdapter;
    RecyclerView.LayoutManager layoutManager;

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

    public class RCVAdapter extends RecyclerView.Adapter<RCVAdapter.ViewHolder>{

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView title, place;
            ImageView options, image;

            public ViewHolder(View itemView) {
                super(itemView);
                title = (TextView) itemView.findViewById(R.id.tvCardTitle);
                place = (TextView) itemView.findViewById(R.id.tvCardPlace);
                options = (ImageView) itemView.findViewById(R.id.ivCardOptions);
                image = (ImageView) itemView.findViewById(R.id.ivCardImage);
            }
        }

        @Override
        public RCVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_story_one,parent,false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RCVAdapter.ViewHolder holder, int position) {
            holder.title.setText("Test Title");
            holder.place.setText("Test Place");
        }

        @Override
        public int getItemCount() {
            return 5;
        }

    }
}

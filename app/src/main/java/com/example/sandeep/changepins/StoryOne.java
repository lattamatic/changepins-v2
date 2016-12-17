package com.example.sandeep.changepins;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by sandeep on 25/11/16.
 */
public class StoryOne extends ChangePinsActivity{

    TextView title,content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title = (TextView) findViewById(R.id.tvStoryTitle);
        content = (TextView) findViewById(R.id.tvStoryContent);

        title.setText(getIntent().getStringExtra("title"));
        content.setText(getIntent().getStringExtra("content"));
    }

    @Override
    protected int getTitleText() {
        return R.string.app_name;
    }

    @Override
    protected int getLayout() {
        return R.layout.story_one;
    }
}

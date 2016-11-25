package com.example.sandeep.changepins;

/**
 * Created by sandeep on 25/11/16.
 */

public class Story {

    String title;
    String content;
    int storyType;

    public Story(int storyType, String title, String content) {
        this.storyType=storyType;
        this.title = title;
        this.content = content;
    }

    public int getStoryType() {
        return storyType;
    }

    public void setStoryType(int storyType) {
        this.storyType = storyType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

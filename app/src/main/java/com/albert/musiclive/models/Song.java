package com.albert.musiclive.models;

public class Song {
    private String title,likeCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public Song() {
    }

    public Song(String title, String likeCount) {
        this.title = title;
        this.likeCount = likeCount;
    }
}

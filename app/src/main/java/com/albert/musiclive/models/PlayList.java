package com.albert.musiclive.models;

public class PlayList {

    private String playlistId, musicId, userId;

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public PlayList() {
    }

    public PlayList(String musicId, String userId) {
        this.musicId = musicId;
        this.userId = userId;
    }
}

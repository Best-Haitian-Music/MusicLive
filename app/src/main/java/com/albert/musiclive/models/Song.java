package com.albert.musiclive.models;

public class Song {
    private String songId,albumTitle,artistId,commentsCount,creatAt,genre,likesCount,songLink,title,updateAt;

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(String commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(String creatAt) {
        this.creatAt = creatAt;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(String likesCount) {
        this.likesCount = likesCount;
    }

    public Song() {
    }

    public Song(String albumTitle, String artistId, String commentsCount, String creatAt, String genre, String likesCount, String songLink, String title, String updateAt) {
        this.albumTitle = albumTitle;
        this.artistId = artistId;
        this.commentsCount = commentsCount;
        this.creatAt = creatAt;
        this.genre = genre;
        this.likesCount = likesCount;
        this.songLink = songLink;
        this.title = title;
        this.updateAt = updateAt;
    }
}

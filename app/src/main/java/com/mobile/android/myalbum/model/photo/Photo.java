package com.mobile.android.myalbum.model.photo;

public class Photo {
    private int albumID;
    private String url, thumbnailUrl,title;

    public Photo(int albumID, String url, String thumbnailUrl, String title) {
        this.albumID = albumID;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

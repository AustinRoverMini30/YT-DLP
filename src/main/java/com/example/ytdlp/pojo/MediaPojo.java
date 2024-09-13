package com.example.ytdlp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaPojo {
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("thumbnail")
    private String thumbnailUrl;

    @JsonProperty("description")
    private String description;

    @JsonProperty("original_url")
    private String mediaUrl;

    public String getMediaUrl() {
        return mediaUrl;
    }

    public String getUrlDomain() {
        return urlDomain;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public String getChannel() {
        return channel;
    }

    public int getLikeNb() {
        return likeNb;
    }

    public String getDuration() {
        return duration;
    }

    @JsonProperty("webpage_url_domain")
    private String urlDomain;

    @JsonProperty("upload_date")
    private String uploadDate;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("like_count")
    private int likeNb;

    @JsonProperty("duration_string")
    private String duration;



    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }
}

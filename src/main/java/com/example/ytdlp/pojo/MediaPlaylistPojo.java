package com.example.ytdlp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaPlaylistPojo {
    @JsonProperty("url")
    private String mediaUrl;

    public String getMediaUrl() {
        return mediaUrl;
    }
}

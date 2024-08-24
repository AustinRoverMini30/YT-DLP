package com.example.ytdlp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaPlaylist {
    @JsonProperty("url")
    private String mediaUrl;

    public String getMediaUrl() {
        return mediaUrl;
    }
}

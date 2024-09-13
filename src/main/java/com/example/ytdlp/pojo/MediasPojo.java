package com.example.ytdlp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediasPojo {
    @JsonProperty("entries")
    private MediaPlaylistPojo[] mediasPojos;

    public MediaPlaylistPojo[] getMediasPojos() {
        return mediasPojos;
    }
}

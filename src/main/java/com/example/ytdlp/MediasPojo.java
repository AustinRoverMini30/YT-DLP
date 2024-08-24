package com.example.ytdlp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediasPojo {
    @JsonProperty("entries")
    private MediaPlaylist[] mediasPojos;

    public MediaPlaylist[] getMediasPojos() {
        return mediasPojos;
    }
}

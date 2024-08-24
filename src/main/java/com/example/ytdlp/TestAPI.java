package com.example.ytdlp;

import com.example.ytdlp.ytdlp.Media;
import com.example.ytdlp.ytdlp.YTDLP;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class TestAPI {
    public static void main(String[] args) throws JsonProcessingException {
        YTDLP ytdlp = new YTDLP(".\\", "");

        ytdlp.update();

        List<Media> test = ytdlp.createMedia("https://youtu.be/jO8gTE6tp3c?si=cSP2fcexZOGdouEQ");

        for (Media media : test){
            media.setExt("mp3");
        }

        ytdlp.downloadMedia(test);

        //System.out.println(ytdlp.getJson("https://youtu.be/jO8gTE6tp3c?si=cSP2fcexZOGdouEQ"));
    }
}

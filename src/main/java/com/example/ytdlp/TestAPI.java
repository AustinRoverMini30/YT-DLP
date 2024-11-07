package com.example.ytdlp;

import com.example.ytdlp.ytdlp.Media;
import com.example.ytdlp.ytdlp.YTDLP;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class TestAPI {
    public static void main(String[] args) throws JsonProcessingException {
        YTDLP ytdlp = new YTDLP(".\\", ".\\");

        ytdlp.update();

        //System.out.println(ytdlp.getJson("https://youtu.be/U9FzgsF2T-s?si=FYsP4fdTgZIoHFr-"));

        //b ytdlp.setSimulate(true);

        List<Media> test = ytdlp.createMedia("https://youtu.be/x76L5vO8ugU?si=0v0uribn7boeKn0v");

        for (Media media : test){
            media.setExt(".mp3");
        }

        ytdlp.downloadMedia(test);
    }
}

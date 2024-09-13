package com.example.ytdlp;

import com.example.ytdlp.ytdlp.Media;
import com.example.ytdlp.ytdlp.YTDLP;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class TestAPI {
    public static void main(String[] args) throws JsonProcessingException {
        YTDLP ytdlp = new YTDLP(".\\", ".\\");

        ytdlp.update();

        System.out.println(ytdlp.getJson("https://youtu.be/3-NrCcr8Bcg?si=MnPHx2F7-F5DHb_Q"));

        //b ytdlp.setSimulate(true);

        //List<Media> test = ytdlp.createMedia("https://youtu.be/3-NrCcr8Bcg?si=MnPHx2F7-F5DHb_Q");

        /*
        for (Media media : test){
            media.setExt(".mp4");
        }

         */

        //ytdlp.downloadMedia(test);
    }
}

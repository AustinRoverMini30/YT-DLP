package com.example.ytdlp.ytdlp;

import com.example.ytdlp.MediaPojo;
import com.example.ytdlp.MediasPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class YTDLP {
    private String pathYTDLP;
    private String pathFFMPEG;
    private List<Media> file;
    private boolean simulate;

    public boolean isSimulate() {
        return simulate;
    }

    public void setSimulate(boolean simulate) {
        this.simulate = simulate;
    }

    public YTDLP(String pathYTDLP, String pathFFMPEG){
        this.pathYTDLP = pathYTDLP;
        this.pathFFMPEG = pathFFMPEG;
        file = new LinkedList<>();
        simulate = false;
    }

    public String getJson(String url){
        return sendRequest(new String[]{".\\yt-dlp.exe",  "--no-warnings", "-J", url});
    }

    public List<Media> createMedia(String url) throws JsonProcessingException {

        List<Media> list = new LinkedList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try{
            MediasPojo test = objectMapper.readValue(sendRequest(new String[]{".\\yt-dlp.exe", "--flat-playlist", "--no-warnings", "-J", url}), MediasPojo.class);

            for (int i = 0; i < test.getMediasPojos().length; i++){

                MediaPojo temp = objectMapper.readValue(sendRequest(new String[]{".\\yt-dlp.exe", "--no-warnings", "-j", test.getMediasPojos()[i].getMediaUrl()}), MediaPojo.class);

                list.add(new Media(temp.getMediaUrl(), temp.getThumbnailUrl(), temp.getDescription(), temp.getTitle(), temp.getUrlDomain(), temp.getUploadDate()
                        , temp.getChannel(), temp.getLikeNb(), temp.getDuration()));
            }

        } catch (Exception e) {
            MediaPojo test = objectMapper.readValue(sendRequest(new String[]{".\\yt-dlp.exe", "--no-warnings", "-J", url}), MediaPojo.class);
            list.add(new Media(test.getMediaUrl(), test.getThumbnailUrl(), test.getDescription(), test.getTitle(), test.getUrlDomain(), test.getUploadDate()
                    , test.getChannel(), test.getLikeNb(), test.getDuration()));
        }

        return list;
    }

    public void downloadMedia(List<Media> media){

        for (Media current : media){
            downloadMedia(current);

            if (current.isNeedConvert()){
                convertMedia(current);
            }
        }
    }

    public void downloadMedia(Media media){
        downloadMedia(new String[] {}, media.getMediaUrl(), new String[]{"-o" , "\"" + media.getFilename() + "\""});
    }

    public void downloadMedia(String[] antOptions, String url, String[] postOptions){

        List<String> list = new LinkedList<>();

        list.add(".\\yt-dlp.exe");

        if (pathFFMPEG != null){
            list.add("--ffmpeg-location");
            list.add(pathFFMPEG + "ffmpeg-master-latest-win64-gpl/bin/");
        }
        for (String string : antOptions){
            list.add(string);
        }
        list.add(url);
        for (String string : postOptions){
            list.add(string);
        }

        sendRequest(list.toArray(new String[0]));
    }

    public String getVersion(){
        return sendRequest(new String[]{".\\yt-dlp.exe", "--version"});
    }

    public void update(){
        sendRequest(new String[]{".\\yt-dlp.exe", "--update"});
    }

    public String sendRequest(String[] request){

        List<String> list = new LinkedList<>();
        String line;
        StringBuilder output = new StringBuilder();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(request);
            processBuilder.redirectErrorStream(true); // Pour capturer les erreurs dans le même flux

            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while ((line = reader.readLine()) != null) {
                output.append(line);
                System.out.println(line);
            }

            process.waitFor();
            reader.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public void convertMedia(Media media){
        sendRequest(new String[]{".\\ffmpeg-master-latest-win64-gpl\\bin\\ffmpeg.exe", "-i", media.getTitle()+".webm", "-b:a", media.getBitRate() + " k", media.getTitle()+"."+media.getExt()});
    }

}

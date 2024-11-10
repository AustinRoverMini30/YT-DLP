package com.example.ytdlp.controller;

import com.example.ytdlp.ytdlp.Media;
import com.fasterxml.jackson.core.JsonProcessingException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.List;

import static com.example.ytdlp.MINI_Downloader.ytdlp;

public class HomeController {

    @FXML
    private Button download;

    @FXML
    private TextField labelUrl;

    @FXML
    private ImageView thumbnail;

    @FXML
    private Pane window;

    public void initialize() {
        System.out.println("HomeController initialized");

        ytdlp.update();

        download.setOnAction(event -> {
            List<Media> test = null;
            try {
                test = ytdlp.createMedia(labelUrl.getText());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            for (Media media : test){
                media.setExt(".mp3");
            }

            System.out.println(test.get(0).getMediaThumbnailUrl());

            BufferedImage webImage = null;
            try {
                webImage = ImageIO.read(new URL(test.get(0).getMediaThumbnailUrl()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ImageIO.write(webImage, "png", baos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            InputStream is = new ByteArrayInputStream(baos.toByteArray());

            thumbnail.setImage(new Image(is));

            ytdlp.downloadMedia(test);
        });
    }

}

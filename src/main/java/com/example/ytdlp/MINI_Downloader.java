package com.example.ytdlp;

import com.example.ytdlp.model.Settings;
import com.example.ytdlp.model.SettingsManager;
import com.example.ytdlp.ytdlp.YTDLP;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MINI_Downloader extends Application {

    public static Settings settings;
    public static SettingsManager settingsManager;
    public static YTDLP ytdlp = new YTDLP(".\\", ".\\");

    @Override
    public void start(Stage stage) throws Exception {

        settingsManager = new SettingsManager();

        settings = settingsManager.loadSettings("settings.bin");

        settings.backFromFile("version.bin");

        settings.loadVersion("version.bin");

        FXMLLoader fxmlLoader = new FXMLLoader(MINI_Downloader.class.getResource("Home.fxml"));

        Parent root = fxmlLoader.load();
        root.getTransforms().add(new Scale(settings.getScaleFactor(), settings.getScaleFactor()));
        Scene scene = new Scene(root, settings.getNewWidth(), settings.getNewHeight());

        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("MINI_Downloader");

        //stage.setFullScreen(true);
        //stage.getIcons().add(new javafx.scene.image.Image(MINI_Downloader.class.getResourceAsStream("assets/QuantumGamesLogoSansTexte.png")));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

package com.example.ytdlp.model;

import java.io.*;

public class SettingsManager {
    public Settings loadSettings(String path) throws IOException {

        Settings settings;

        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream dis = new ObjectInputStream(fis);

            settings = (Settings) dis.readObject();

            dis.close();
            fis.close();

        } catch (Exception e) {
            settings = new Settings();
            saveToFile(path, settings);
        }

        return settings;
    }

    public void saveToFile(String path, Settings settings) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(settings);

        oos.close();
        fos.close();
    }
}

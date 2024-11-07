package com.example.ytdlp.model;

import java.io.*;

public class Settings implements Serializable {
    private String color1;
    private String color2;
    private Version version;
    private int cacheUsage;
    private double scaleFactor;
    private double originalWidth;
    private double originalHeight;
    private double newWidth;
    private double newHeight;

    public double getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor() {
        double scaleX = newWidth / originalWidth;
        double scaleY = newHeight / originalHeight;

        this.scaleFactor = Math.min(scaleX, scaleY);
    }

    public double getNewWidth() {
        return newWidth;
    }

    public void setNewWidth(double newWidth) {
        this.newWidth = newWidth;
        setScaleFactor();
    }

    public double getNewHeight() {
        return newHeight;
    }

    public void setNewHeight(double newHeight) {
        this.newHeight = newHeight;
        setScaleFactor();
    }

    public Settings(){
        color1 = "-fx-background-color: #141526;";
        color2 = "-fx-background-color: #26273b;";
        version = new Version("NC", "NC", "NC", "NC");
        cacheUsage = 0;
        originalWidth = 1920;
        originalHeight = 1080;
        newWidth = originalWidth;
        newHeight = originalHeight;

        setScaleFactor();
    }

    public int getCacheUsage() {
        return cacheUsage;
    }
    public void setCacheUsage(int cacheUsage) {
        this.cacheUsage = cacheUsage;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public void saveToFile(String path) throws IOException {

        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(version);

        oos.close();
        fos.close();
    }

    public Version backFromFile(String path) throws IOException, ClassNotFoundException {
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream dis = new ObjectInputStream(fis);

            Version versionTemp = (Version) dis.readObject();

            dis.close();
            fis.close();

            return versionTemp;
        } catch (FileNotFoundException e) {
            Version version = new Version("NC", "NC", "NC", "NC");

            saveToFile("Version.bin");

            return version;
        }
    }

    public void loadVersion(String path) throws IOException, ClassNotFoundException {
        this.version = backFromFile(path);
    }
}

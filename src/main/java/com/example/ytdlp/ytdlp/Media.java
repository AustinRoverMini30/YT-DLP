package com.example.ytdlp.ytdlp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Media {

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private String filename;
    private String mediaUrl;
    private String mediaThumbnailUrl;
    private String description;
    private String title;
    private String urlDomain;
    private String uploadDate;
    private String channel;
    private int likeNb;
    private String duration;

    private int bitRate;
    private String ext;
    private boolean needConvert;

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMediaThumbnailUrl() {
        return mediaThumbnailUrl;
    }

    public void setMediaThumbnailUrl(String mediaThumbnailUrl) {
        this.mediaThumbnailUrl = mediaThumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Media(String mediaUrl, String mediaThumbnailUrl, String description, String title, String urlDomain, String uploadDate, String channel, int likeNb, String duration) {
        this.mediaUrl = mediaUrl;
        this.mediaThumbnailUrl = mediaThumbnailUrl;
        this.description = description;
        this.title = title;
        this.urlDomain = urlDomain;
        this.uploadDate = uploadDate;
        this.channel = channel;
        this.likeNb = likeNb;
        this.duration = duration;

        this.filename = title.replaceAll("[\\\\/:*?\"<>|]", " ");;

        this.ext = "webm";
        this.bitRate = 320;
        this.needConvert = false;
    }

    public int getBitRate() {
        return bitRate;
    }

    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }

    public String getExt() {
        return ext;
    }

    public boolean isNeedConvert() {
        return needConvert;
    }

    public void setNeedConvert(boolean needConvert) {
        this.needConvert = needConvert;
    }

    public void setExt(String ext) {
        this.ext = ext;

        if (!ext.equals(".webm")){
            needConvert = true;
        }
    }
}

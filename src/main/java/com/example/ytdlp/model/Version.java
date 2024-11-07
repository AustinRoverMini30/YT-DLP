package com.example.ytdlp.model;

import java.io.Serializable;

public class Version implements Serializable {

    private String versionQuantumGames;
    private String versionAPI;
    private String versionUpdate;
    private String packageUrl;

    public Version(String versionQuantumGames, String versionUpdate, String versionAPI, String packageUrl) {
        this.versionQuantumGames = versionQuantumGames;
        this.versionUpdate = versionUpdate;
        this.packageUrl = packageUrl;
        this.versionAPI = versionAPI;
    }

    public String getVersionQuantumGames() {
        return versionQuantumGames;
    }

    public void setVersionQuantumGames(String versionQuantumGames) {
        this.versionQuantumGames = versionQuantumGames;
    }

    public String getVersionUpdate() {
        return versionUpdate;
    }

    public void setVersionUpdate(String versionUpdate) {
        this.versionUpdate = versionUpdate;
    }

    public String getVersionAPI() {
        return versionAPI;
    }

    public void setVersionAPI(String versionAPI) {
        this.versionAPI = versionAPI;
    }

    public boolean comparatorversionQuantumGames(Version version) {
        String temp = version.getVersionQuantumGames();

        return versionQuantumGames.equals(temp);
    }

    public boolean comparatorVersionUpdate(Version version) {
        String temp = version.getVersionUpdate();

        return versionUpdate.equals(temp);
    }

    public boolean comparatorVersionAPI(Version version) {
        String temp = version.getVersionAPI();

        return versionAPI.equals(temp);
    }

    public String getUpdatePackageUrl() {
        return this.packageUrl;
    }

}

package com.project1.Models;

public class App {
    public static App instance;
    private GameSetting gameSetting;
    private PlayerProfile playerProfile;
    private PlayingInfo playingInfo;
    private boolean isGuest = false;

    App() {
        gameSetting = new GameSetting();
        playerProfile = new PlayerProfile();
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public void setPlayingInfo(PlayingInfo playingInfo) {
        this.playingInfo = playingInfo;
    }

    public PlayingInfo getPlayingInfo() {
        return playingInfo;
    }

    public void setGameSetting(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
    }

    public GameSetting getGameSetting() {
        return gameSetting;
    }

    public void setPlayerProfile(PlayerProfile playerProfile, boolean isGuest) {
        this.playerProfile = playerProfile;
        this.isGuest = isGuest;
    }

    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }

    public boolean isGuest() {
        return isGuest;
    }

}

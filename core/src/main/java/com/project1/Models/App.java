package com.project1.Models;

public class App {
    public static App instance;
    private GameSetting gameSetting;
    private PlayerProfile playerProfile;
    private boolean isGuest = false;
    private Player player;

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

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
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

package com.project1.Models;

public class GameSetting {
    private float musicVolume = 0.5f;
    private float sfxVolume = 0.5f;
    private boolean sfxIsEnabled = false;
    private boolean GrayscaleMode = false;
    private boolean autoReload = false;
    private String heroName = null;
    private String weapon = null;
    private int initialTime = 0;

    public GameSetting() {
    }

    public int getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(int initialTime) {
        this.initialTime = initialTime;
    }

    public float getSfxVolume() {
        return sfxVolume;
    }

    public void setSfxVolume(float volume) {
        this.sfxVolume = volume;
    }

    public boolean isSfxIsEnabled() {
        return sfxIsEnabled;
    }

    public void setSfxIsEnabled(boolean enabled) {
        this.sfxIsEnabled = enabled;
    }

    public float getMusicVolume() {
        return musicVolume;
    }

    public void setMusicVolume(float musicVolume) {
        this.musicVolume = musicVolume;
    }

    public boolean isGrayscaleMode() {
        return GrayscaleMode;
    }

    public void setGrayscaleMode(boolean grayscaleMode) {
        GrayscaleMode = grayscaleMode;
    }

    public boolean isAutoReload() {
        return autoReload;
    }

    public void setAutoReload(boolean autoReload) {
        this.autoReload = autoReload;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setWeapon(String name) {
        this.weapon = name;
    }

    public String getWeapon() {
        return weapon;
    }
}

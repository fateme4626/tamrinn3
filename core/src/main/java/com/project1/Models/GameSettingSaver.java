package com.project1.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;

public class GameSettingSaver {
    private static GameSettingSaver instance;
    private static final String settingDir = "core/src/main/java/com/project1/savedData/gamePrefs/";
    private static final Json json = new Json();

    public static GameSettingSaver getInstance() {
        if (instance == null) {
            instance = new GameSettingSaver();
        }
        return instance;
    }

    public void savePref(GameSetting setting) {
        String data = json.toJson(setting);
        FileHandle file = Gdx.files.local(settingDir + App.getInstance().getPlayerProfile().getUsername() + ".json");
        file.writeString(Base64Coder.encodeString(data), false);
    }

    public GameSetting loadPref(String username) {
        FileHandle file = Gdx.files.local(settingDir + username + ".json");
        if (!file.exists()) return null;

        String encodedData = file.readString();
        String decodedData = Base64Coder.decodeString(encodedData);
        return json.fromJson(GameSetting.class, decodedData);
    }

    public boolean deleteSetting(String username) {
        FileHandle file = Gdx.files.local(settingDir + username + ".json");
        return file.delete();
    }
}

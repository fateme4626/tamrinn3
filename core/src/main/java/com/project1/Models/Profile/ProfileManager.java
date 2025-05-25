package com.project1.Models.Profile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.project1.Models.PlayerProfile;

public class ProfileManager {
    private static ProfileManager instance;
    private static final String PROFILE_DIR = "core/src/main/java/com/project1/savedData/profiles/";
    private static final Json json = new Json();

    public static ProfileManager getInstance() {
        if (instance == null) {
            instance = new ProfileManager();
        }
        return instance;
    }

    public void saveProfile(PlayerProfile profile) {
        String data = json.toJson(profile);
        FileHandle file = Gdx.files.local(PROFILE_DIR + profile.getUsername() + ".json");
        file.writeString(Base64Coder.encodeString(data), false);
    }

    public PlayerProfile loadProfile(String username) {
        FileHandle file = Gdx.files.local(PROFILE_DIR + username + ".json");
        if (!file.exists()) return null;

        String encodedData = file.readString();
        String decodedData = Base64Coder.decodeString(encodedData);
        return json.fromJson(PlayerProfile.class, decodedData);
    }

    public boolean deleteProfile(String username) {
        FileHandle file = Gdx.files.local(PROFILE_DIR + username + ".json");
        return file.delete();
    }
}

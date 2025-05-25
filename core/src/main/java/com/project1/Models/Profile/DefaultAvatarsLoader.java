package com.project1.Models.Profile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public class DefaultAvatarsLoader {
    private static DefaultAvatarsLoader instance;
    public Array<String> avatarPaths = new Array<>();

    public static DefaultAvatarsLoader getInstance() {
        if (instance == null) {
            instance = new DefaultAvatarsLoader();
        }
        return instance;
    }

    DefaultAvatarsLoader() {
        avatarPaths = loadAvatarPaths();
    }

    private Array<String> loadAvatarPaths() {
        Array<String> avatars = new Array<>();
        FileHandle dir = Gdx.files.internal("assets/avatar");

        if (dir.isDirectory()) {
            FileHandle[] files = dir.list(".png");

            for (FileHandle file : files) {
                if (file.extension().equalsIgnoreCase("png")) {
                    avatars.add(file.path());
                }
            }
        }

        return avatars;
    }

    public Array<String> getAvatarPaths() {
        return avatarPaths;
    }
}


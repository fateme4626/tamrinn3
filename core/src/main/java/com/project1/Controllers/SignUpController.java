package com.project1.Controllers;

import com.badlogic.gdx.utils.Array;
import com.project1.Main;
import com.project1.Models.*;
import com.project1.Models.Enums.SignUpRegex;
import com.project1.Models.Profile.ProfileManager;
import com.project1.Models.Profile.DefaultAvatarsLoader;
import com.project1.Views.SignUpMenu;
import com.project1.Views.StartMenu;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignUpController {
    private SignUpMenu view; //we store view to have access to its fields

    public void setView(SignUpMenu view) {
        this.view = view;
    }

    //this function checks if any button have pressed do suitable reaction
    public void handleMainMenuButton() {
        if (view != null) {
            //is checked means it is pressed
            if (view.getSignButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                String username = view.getUsernameField().getText();
                String password = view.getPasswordField().getText().trim();
                String securityQuestion = view.getSecurityQuestion().getText();
                if (view.getUsernameField().getText().trim().equals("")) {
                    view.getUsernameField().setText("username is empty!");
                } else if (view.getPasswordField().getText().equals("")) {
                    view.getPasswordField().setText("password is empty!");
                } else if(ProfileManager.getInstance().loadProfile(username) != null) {
                    view.getUsernameField().setText("username already exists!");
                } else if (!SignUpRegex.Password.getMatcher(password).matches()) {
                    view.getPasswordField().setText("password is weak!");
                } else if (password.length() < 8) {
                    view.getPasswordField().setText("password length must be at least 8!");
                } else if (securityQuestion.trim().equals("")) {
                    view.getSecurityQuestion().setText("security question is empty!");
                } else {
//                    String hashedPassword = hashPassword(password);
                    PlayerProfile newPlayer = new PlayerProfile(username, password, securityQuestion);
                    getRandomAvatar(newPlayer);
                    App.getInstance().setPlayerProfile(newPlayer, false);
                    //TODO momkene hazf koni
                    ProfileManager.getInstance().saveProfile(newPlayer);
                    App.getInstance().setGameSetting(new GameSetting());
                    GameSettingSaver.getInstance().savePref(App.getInstance().getGameSetting());
                    view.removeActor();
                    view.getMainLabel().setText("welcome  \"" + username + "\"!");
                    view.getSignButton().setText("Back");
                }
                view.getSignButton().setChecked(false);
            } else if (view.getBackButton().isChecked()) {
                Main.getInstance().setScreen(new StartMenu(new StartMenuController(),
                    GameAssetManager.getInstance().getSkin()));
            }
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getRandomAvatar(PlayerProfile newPlayer) {
        Array<String> defaultAvatars = DefaultAvatarsLoader.getInstance().getAvatarPaths();
        String randomAvatar = defaultAvatars.random();
        newPlayer.setAvatarPath(randomAvatar);
    }
}

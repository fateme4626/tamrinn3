package com.project1.Controllers;

import com.project1.Main;
import com.project1.Models.App;
import com.project1.Models.Enums.SignUpRegex;
import com.project1.Models.GameAssetManager;
import com.project1.Models.GameSettingSaver;
import com.project1.Models.Profile.ProfileManager;
import com.project1.Views.ProfileMenuScreens.ChangeAvatarScreen;
import com.project1.Views.ProfileMenuScreens.ProfileMenu;
import com.project1.Views.ProfileMenuScreens.ChangePasswordScreen;
import com.project1.Views.MainMenu;
import com.project1.Views.ProfileMenuScreens.ChangeUsernameScreen;
import com.project1.Views.StartMenu;

public class ProfileController {
    public void handleProfileMenu(ProfileMenu view) {
        if (view != null) {
            if (view.getBackButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new MainMenu(new MainMenuController(), GameAssetManager.getInstance().getSkin()));
            } else if (view.getChangeUserNameButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new ChangeUsernameScreen(new ProfileController(), GameAssetManager.getInstance().getSkin()));
            } else if (view.getChangePasswordButton().isChecked()) {
                if (App.getInstance().isGuest()) {
                    return;
                }
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new ChangePasswordScreen(new ProfileController(), GameAssetManager.getInstance().getSkin()));
            } else if (view.getChangeAvatarButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new ChangeAvatarScreen(new ProfileController(), GameAssetManager.getInstance().getSkin()));
            } else if (view.getDeleteAccountButton().isChecked()) {
                if (App.getInstance().isGuest()) {
                    return;
                }
                //Todo
                //dialog are you sure?
                ProfileManager.getInstance().deleteProfile(App.getInstance().getPlayerProfile().getUsername());
                GameSettingSaver.getInstance().deleteSetting(App.getInstance().getPlayerProfile().getUsername());
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new StartMenu(new StartMenuController(), GameAssetManager.getInstance().getSkin()));
            } else if (view.getLogoutButton().isChecked()) {
                //TODO
                //are you sure you wanna logout?
                ProfileManager.getInstance().saveProfile(App.getInstance().getPlayerProfile());
                GameSettingSaver.getInstance().savePref(App.getInstance().getGameSetting());
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new StartMenu(new StartMenuController(), GameAssetManager.getInstance().getSkin()));
            }
        }
    }

    public void handleChangePassword(ChangePasswordScreen view) {
        if (view.getConfirmButton().isChecked()) {
            String password = view.getNewPasswordField().getText().trim();
            if (password.isEmpty()) {
                view.getNewPasswordField().setText("password is empty!");
                view.getConfirmButton().setChecked(false);
            } else if (!SignUpRegex.Password.getMatcher(password).matches()) {
                view.getNewPasswordField().setText("password is weak!");
                view.getConfirmButton().setChecked(false);
            } else if (password.equals(App.getInstance().getPlayerProfile().getPassword())) {
                view.getNewPasswordField().setText("please enter a new password!");
                view.getConfirmButton().setChecked(false);
            } else if (password.length() < 8) {
                view.getNewPasswordField().setText("password length must be at least 8!");
                view.getConfirmButton().setChecked(false);
            } else {
                App.getInstance().getPlayerProfile().setPassword(password);
                ProfileManager.getInstance().saveProfile(App.getInstance().getPlayerProfile());
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new ProfileMenu(new ProfileController(), GameAssetManager.getInstance().getSkin()));
            }
        } else if (view.getBackButton().isChecked()) {
            Main.getInstance().getScreen().dispose();
            Main.getInstance().setScreen(new ProfileMenu(new ProfileController(), GameAssetManager.getInstance().getSkin()));
        }
    }

    public void handleChangeUsername(ChangeUsernameScreen view) {
        if (view != null) {
            if (view.getConfirmButton().isChecked()) {
                String newName = view.getNewNameField().getText();
                if (newName.trim().isEmpty()) {
                    view.getNewNameField().setText("New name is empty!");
                } else if (newName.equals(App.getInstance().getPlayerProfile().getUsername())) {
                    view.getNewNameField().setText("please enter a new name!");
                } else if (ProfileManager.getInstance().loadProfile(newName) != null) {
                    view.getNewNameField().setText("username already exist!");
                } else {
                    App.getInstance().getPlayerProfile().setUsername(newName);
                    ProfileManager.getInstance().saveProfile(App.getInstance().getPlayerProfile());
                    view.removeActors();
                }
                view.getConfirmButton().setChecked(false);
            } else if (view.getBackButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new ProfileMenu(new ProfileController(), GameAssetManager.getInstance().getSkin()));
            }
        }
    }

    public void handleChangeAvatar(String avatarPath) {
        App.getInstance().getPlayerProfile().setAvatarPath(avatarPath);
        ProfileManager.getInstance().saveProfile(App.getInstance().getPlayerProfile());
    }

    public void goBack() {
        Main.getInstance().getScreen().dispose();
        Main.getInstance().setScreen(new MainMenu(new MainMenuController(), GameAssetManager.getInstance().getSkin()));
    }

}

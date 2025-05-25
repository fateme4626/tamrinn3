package com.project1.Controllers;

import com.project1.Main;
import com.project1.Models.*;
import com.project1.Models.Profile.ProfileManager;
import com.project1.Views.*;
import com.project1.Views.ProfileMenuScreens.ChangePasswordScreen;

public class LoginMenuController {
    private LoginMenu view; //we store view to have access to its fields

    public void setView(LoginMenu view) {
        this.view = view;
    }

    public void handleMenuButton() {
        if (view != null) {
            if (view.getLoginButton().isChecked()) {
                String username = view.getUsernameField().getText();
                String password = view.getPasswordField().getText();
                view.getLoginButton().setChecked(false);
                if (username.trim().equals("")) {
                    view.getUsernameField().setText("username is empty!!");
                } else if (password.trim().equals("")) {
                    view.getPasswordField().setText("password is empty!!");
                } else {
                    PlayerProfile player = ProfileManager.getInstance().loadProfile(username);
                    if (player == null) {
                        view.getUsernameField().setText("username not found!!");
                        return;
                    }
                    String correctPassword = player.getPassword();
                    if (!correctPassword.equals(password)) {
                        view.getPasswordField().setText("password is incorrect!!");
                        return;
                    }
                    App.getInstance().setPlayerProfile(player, false);
                    GameSetting setting = GameSettingSaver.getInstance().loadPref(player.getUsername());
                    App.getInstance().setGameSetting(setting);
                    Main.getInstance().getScreen().dispose();
                    Main.getInstance().setScreen(new MainMenu(new MainMenuController(), GameAssetManager.getInstance().getSkin()));
                }
            } else if (view.getForgotPasswordButton().isChecked()) {
                Main.getInstance().getScreen().hide();
                view.getForgotPasswordButton().setChecked(false);
                Main.getInstance().setScreen(new ForgotPasswordMenu(new LoginMenuController(), GameAssetManager.getInstance().getSkin()));
            } else if (view.getBackButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                view.getBackButton().setChecked(false);
                Main.getInstance().setScreen(new StartMenu(new StartMenuController(), GameAssetManager.getInstance().getSkin()));
            }
        }
    }

    public void handleForgotPasswordButton(ForgotPasswordMenu view) {
        if (view.getLoginButton().isChecked()) {
            String username = view.getUsernameField().getText();
            String password = view.getSecurityQuestionField().getText();
            view.getLoginButton().setChecked(false);
            if (username.trim().equals("")) {
                view.getUsernameField().setText("username is empty!!");
                view.getLoginButton().setChecked(false);
            } else if (password.trim().equals("")) {
                view.getSecurityQuestionField().setText("your answer is empty!!");
                view.getLoginButton().setChecked(false);
            } else {
                PlayerProfile player = ProfileManager.getInstance().loadProfile(username);
                if (player == null) {
                    view.getUsernameField().setText("username not found!!");
                    view.getLoginButton().setChecked(false);
                    return;
                }
                String correctAnswer = player.getAnswerSecurityQuestion();
                if (!correctAnswer.equals(password)) {
                    view.getSecurityQuestionField().setText("answer is incorrect!!");
                    view.getLoginButton().setChecked(false);
                    return;
                }
                App.getInstance().setPlayerProfile(player, false);
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new ChangePasswordScreen(new ProfileController(), GameAssetManager.getInstance().getSkin()));
                view.getLoginButton().setChecked(false);
            }
        } else if (view.getBackButton().isChecked()) {
            Main.getInstance().getScreen().dispose();
            view.getBackButton().setChecked(false);
            Main.getInstance().setScreen(new LoginMenu(new LoginMenuController(), GameAssetManager.getInstance().getSkin()));
        }
    }

}

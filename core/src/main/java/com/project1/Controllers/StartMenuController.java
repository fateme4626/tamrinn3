package com.project1.Controllers;

import com.project1.Main;
import com.project1.Models.GameAssetManager;
import com.project1.Views.*;

public class StartMenuController {
    private StartMenu view; //we store view to have access to its fields

    public void setView(StartMenu view) {
        this.view = view;
    }

    //this function checks if any button have pressed do suitable reaction
    public void handleMainMenuButton() {
        if (view != null) {
            if (view.getSignUpButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new SignUpMenu(new SignUpController(), GameAssetManager.getInstance().getSkin()));
                view.getSignUpButton().setChecked(false);
            } else if (view.getLoginButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new LoginMenu(new LoginMenuController(), GameAssetManager.getInstance().getSkin()));
                view.getLoginButton().setChecked(false);
            } else if (view.getSignInAsGuestButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new ContinueAsGuestMenu(new GuestSignInController(), GameAssetManager.getInstance().getSkin()));
                view.getSignInAsGuestButton().setChecked(false);
            }
        }
    }
}

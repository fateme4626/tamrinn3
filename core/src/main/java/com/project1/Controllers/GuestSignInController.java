package com.project1.Controllers;

import com.project1.Main;
import com.project1.Models.App;
import com.project1.Models.GameAssetManager;
import com.project1.Models.PlayerProfile;
import com.project1.Views.ContinueAsGuestMenu;
import com.project1.Views.MainMenu;
import com.project1.Views.StartMenu;

public class GuestSignInController {
    private ContinueAsGuestMenu view; //we store view to have access to its fields

    public void setView(ContinueAsGuestMenu view) {
        this.view = view;
    }

    //this function checks if any button have pressed do suitable reaction
    public void handleMainMenuButton() {
        if (view != null) {
            if (view.getConfirmButton().isChecked()) {
                String username = view.getUsernameField().getText();
                if (username.trim().equals("")) {
                    view.getUsernameField().setText("username can't be empty");
                    view.getConfirmButton().setChecked(false);
                } else {
                    PlayerProfile profile = new PlayerProfile();
                    profile.setUsername(username);
                    SignUpController.getRandomAvatar(profile);
                    App.getInstance().setPlayerProfile(profile, true);
                    Main.getInstance().getScreen().dispose();
                    Main.getInstance().setScreen(new MainMenu(new MainMenuController(), GameAssetManager.getInstance().getSkin()));
                }
            } else if (view.getBackButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new StartMenu(new StartMenuController(), GameAssetManager.getInstance().getSkin()));
            }
        }
    }
}

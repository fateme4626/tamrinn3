package com.project1.Controllers;

import com.project1.Main;
import com.project1.Models.GameAssetManager;
import com.project1.Views.HintMenu;
import com.project1.Views.MainMenu;
import com.project1.Views.PreGameMenu;
import com.project1.Views.ProfileMenuScreens.ProfileMenu;
import com.project1.Views.SettingMenu;

public class MainMenuController {
    private MainMenu view; //we store view to have access to its fields

    public void setView(MainMenu view) {
        this.view = view;
    }

    //this function checks if any button have pressed do suitable reaction
    public void handleMainMenuButton() {
        if (view != null) {
            if (view.getProfileButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new ProfileMenu(new ProfileController(), GameAssetManager.getInstance().getSkin()));
            } else if(view.getSettingsButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new SettingMenu(new SettingController(), GameAssetManager.getInstance().getSkin()));
            } else if(view.getPreGameButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new PreGameMenu(new PreGameMenuController(), GameAssetManager.getInstance().getSkin()));
            } else if(view.getHintMenuButton().isChecked()) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new HintMenu(GameAssetManager.getInstance().getSkin()));
            }
        }
    }
}

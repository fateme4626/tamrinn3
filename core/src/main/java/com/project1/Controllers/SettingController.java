package com.project1.Controllers;

import com.project1.Main;
import com.project1.Models.App;
import com.project1.Models.GameAssetManager;
import com.project1.Models.GameSettingSaver;
import com.project1.Views.MainMenu;
import com.project1.Views.SettingMenu;

public class SettingController {
    private SettingMenu view;

    public void setView(SettingMenu view) {
        this.view = view;
    }

    public void goBack() {
        Main.getInstance().getScreen().dispose();
        Main.getInstance().setScreen(new MainMenu(new MainMenuController(), GameAssetManager.getInstance().getSkin()));
    }

    public void saveSetting() {
        App.getInstance().getGameSetting().setMusicVolume(view.getMusicVolumeSlider().getValue());
        App.getInstance().getGameSetting().setSfxVolume(view.getSfxVolumeSlider().getValue());
        App.getInstance().getGameSetting().setSfxIsEnabled(view.getSfxCheckBox().isChecked());
        App.getInstance().getGameSetting().setAutoReload(view.getAutoReloadButton().isChecked());
        App.getInstance().getGameSetting().setGrayscaleMode(view.getGrayscaleButton().isChecked());
        if (!App.getInstance().isGuest()) {
            GameSettingSaver.getInstance().savePref(App.getInstance().getGameSetting());
        }
        goBack();
    }
}

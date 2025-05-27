package com.project1.Controllers;

import com.project1.Controllers.GameControllers.GameController;
import com.project1.Main;
import com.project1.Models.App;
import com.project1.Models.GameAssetManager;
import com.project1.Models.GameSettingSaver;
import com.project1.Models.Player;
import com.project1.Views.GameView;
import com.project1.Views.MainMenu;
import com.project1.Views.PreGameMenu;

public class PreGameMenuController {
    private PreGameMenu view;

    public void setView(PreGameMenu view) {
        this.view = view;
    }
    public void startGame() {
        App.getInstance().getGameSetting().setHeroName((String)view.getSelectHero().getSelected());
        App.getInstance().getGameSetting().setWeapon((String)view.getSelectWeapon().getSelected());
        App.getInstance().getGameSetting().setInitialTime((int)view.getSelectTime().getSelected());
        GameSettingSaver.getInstance().savePref(App.getInstance().getGameSetting());
        //TODO
        //go to game screen
        Player newPlayer = new Player();
        App.getInstance().setPlayer(newPlayer);
        Main.getInstance().getScreen().dispose();
        Main.getInstance().setScreen(new GameView(new GameController(), GameAssetManager.getInstance().getSkin()));
    }
    public void goBack() {
        Main.getInstance().getScreen().dispose();
        Main.getInstance().setScreen(new MainMenu(new MainMenuController(), GameAssetManager.getInstance().getSkin()));
    }
}

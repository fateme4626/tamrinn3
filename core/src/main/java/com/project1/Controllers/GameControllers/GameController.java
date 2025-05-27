package com.project1.Controllers.GameControllers;


import com.project1.Models.App;
import com.project1.Models.Enums.Weapon;
import com.project1.Models.Player;
import com.project1.Views.GameView;

import java.util.Objects;

public class GameController {
    private GameView view;
    private PlayerController playerController;
    private WorldController worldController;
    private WeaponController weaponController;


    public void setView(GameView view) {
        this.view = view;
        worldController = new WorldController(playerController);
        weaponController = new WeaponController(App.getInstance().getPlayer().getWeapon());
        playerController = new PlayerController();
    }

    public void update() {
        if (view != null) {
            worldController.update();
            playerController.update();
            weaponController.update();
        }
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public WeaponController getWeaponController() {
        return weaponController;
    }
}

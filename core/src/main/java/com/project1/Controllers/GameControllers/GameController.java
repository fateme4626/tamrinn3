package com.project1.Controllers.GameControllers;


import com.project1.Models.Player;
import com.project1.Models.Weapon;
import com.project1.Views.GameView;

public class GameController {
    private GameView view;
    private PlayerController playerController;
    private WorldController worldController;
    private WeaponController weaponController;


    public void setView(GameView view) {
        this.view = view;
        playerController = new PlayerController(new Player());
        worldController = new WorldController(playerController);
        weaponController = new WeaponController(new Weapon());
    }

    public void updateGame() {
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

package com.project1.Controllers.GameControllers;


import com.badlogic.gdx.graphics.Texture;
import com.project1.Main;
import com.project1.Models.App;

public class WorldController {
    private PlayerController playerController;
    private Texture bgtxt;
    private float x = 0;
    private float y = 0;

    public WorldController(PlayerController playerController) {
        this.bgtxt = new Texture("background.png");
        this.playerController = playerController;
    }

    public void update() {
        x = App.getInstance().getPlayer().getPosX();
        y = App.getInstance().getPlayer().getPosY();
        Main.getBatch().draw(bgtxt, x, y);
    }

}

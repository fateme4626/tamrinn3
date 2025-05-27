package com.project1.Controllers.GameControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.project1.Main;
import com.project1.Models.App;
import com.project1.Models.GameAssetManager;
import com.project1.Models.Player;
import com.project1.Views.PauseMenu;

public class PlayerController {
    private Player player;

    public PlayerController() {
        this.player = App.getInstance().getPlayer();

    }

    public void update() {
        player.getPlayerSprite().draw(Main.getBatch());

        if (player.isPlayerIdle()) {
            getAnimation();
        }
        handlePlayerInput();
    }


    public void handlePlayerInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.setPosY(player.getPosY() - player.getSpeed());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.setPosX(player.getPosX() - player.getSpeed());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.setPosY(player.getPosY() + player.getSpeed());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setPosX(player.getPosX() + player.getSpeed());
            player.getPlayerSprite().flip(true, false);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
            Main.getInstance().getScreen().dispose();
            Main.getInstance().setScreen(new PauseMenu());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.R)) {
            player.getWeapon().reload();
        }
    }
    public void getAnimation() {
        Animation<Texture> animation = GameAssetManager.getInstance().getHeroIdleAnimation();

        player.getPlayerSprite().setRegion(animation.getKeyFrame(player.getTime()));

        if (!animation.isAnimationFinished(player.getTime())) {
            player.setTime(player.getTime() + Gdx.graphics.getDeltaTime());
        } else {
            player.setTime(0);
        }
        animation.setPlayMode(Animation.PlayMode.LOOP);
    }
}

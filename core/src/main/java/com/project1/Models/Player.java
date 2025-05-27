package com.project1.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.project1.Models.Enums.Hero;

import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private Texture playerTexture = new Texture(GameAssetManager.getInstance().getFirstIdle());
    private Sprite playerSprite = new Sprite(playerTexture);
    private float posX = 0;
    private float posY = 0;
    private CollisionRect rect ;
    private float time = App.getInstance().getGameSetting().getInitialTime();
    private Weapon weapon;

    public float getSpeed() {
        return Objects.requireNonNull(Hero.findHero(App.getInstance().getGameSetting().getHeroName())).getSpeed();
    }

    private boolean isPlayerIdle = true;
    private boolean isPlayerRunning = false;

    public Player(){
        playerSprite.setPosition((float) Gdx.graphics.getWidth() / 2, (float) Gdx.graphics.getHeight() / 2);
        playerSprite.setSize(playerTexture.getWidth() * 3, playerTexture.getHeight() * 3);
        rect = new CollisionRect((float) Gdx.graphics.getWidth() / 2, (float) Gdx.graphics.getHeight(), playerTexture.getWidth() * 3, playerTexture.getHeight() * 3);
        weapon = new Weapon(Objects.requireNonNull(com.project1.Models.Enums.Weapon.findWeapon(App.getInstance().getGameSetting().getWeapon())));
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Texture getPlayerTexture() {
        return playerTexture;
    }

    public void setPlayerTexture(Texture playerTexture) {
        this.playerTexture = playerTexture;
    }

    public Sprite getPlayerSprite() {
        return playerSprite;
    }

    public void setPlayerSprite(Sprite playerSprite) {
        this.playerSprite = playerSprite;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public CollisionRect getRect() {
        return rect;
    }

    public void setRect(CollisionRect rect) {
        this.rect = rect;
    }


    public boolean isPlayerIdle() {
        return isPlayerIdle;
    }

    public void setPlayerIdle(boolean playerIdle) {
        isPlayerIdle = playerIdle;
    }

    public boolean isPlayerRunning() {
        return isPlayerRunning;
    }

    public void setPlayerRunning(boolean playerRunning) {
        isPlayerRunning = playerRunning;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

}

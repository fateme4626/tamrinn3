package com.project1.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Weapon {
    private final Texture weaponTxt = GameAssetManager.getInstance().getWeapon();
    private Sprite sprite = new Sprite(weaponTxt);
    private int ammo = 30;

    public Weapon(){
        sprite.setX((float) Gdx.graphics.getWidth() / 2 );
        sprite.setY((float) Gdx.graphics.getHeight() / 2);
        sprite.setSize(50,50);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo){
        this.ammo = ammo;
    }
}

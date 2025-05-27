package com.project1.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Weapon {
    private com.project1.Models.Enums.Weapon type;
    private final Texture weaponTxt = GameAssetManager.getInstance().getWeapon();
    private Sprite sprite = new Sprite(weaponTxt);
    private int ammo;

    public Weapon(com.project1.Models.Enums.Weapon type) {
       this.type = type;
        sprite.setX((float) Gdx.graphics.getWidth() / 2 );
        sprite.setY((float) Gdx.graphics.getHeight() / 2);
        sprite.setSize(40,50);
        ammo = type.getMaxAmmo();
    }

    public com.project1.Models.Enums.Weapon getType() {
        return type;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getAmmo() {
        return ammo;
    }

    public void reload() {
        this.ammo = type.getMaxAmmo();
    }

    public void changeAmmo(int ammo){
        this.ammo = ammo;
    }
}

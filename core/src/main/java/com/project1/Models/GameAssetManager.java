package com.project1.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetManager {
    private static GameAssetManager instance;
    private static Animation<Texture> shanaAnimation;
    private static Animation<Texture> scarletAnimation;
    private static Animation<Texture> lilithAnimation;
    private static Animation<Texture> dahserAnimation;
    private static Animation<Texture> diamondAnimation;
    private static Animation<Texture> diamondWalkAnimation;
    private static Animation<Texture> scarletWalkAnimation;
    private static Animation<Texture> lilithWalkAnimation;
    private static Animation<Texture> dahserWalkAnimation;
    private static Animation<Texture> shanaWalkAnimation2;

    String shana0Path = "assets/Heros/Shana/idle/Idle_0 #8330.png";
    String scarlet0Path = "assets/Heros/Scarlet/idle/Idle_0 #8327.png";
    String lilith0Path = "assets/Heros/Lilith/idle/Idle_0 #8333.png";
    String dasher0Path = "assets/Heros/Dasher/idle/Idle_0 #8325.png";
    String diamond0Path = "assets/Heros/Diamond/idle/Idle_0 #8328.png";

    static String smgPath, shotgunPath, revolverPath;
    static Texture smgTxt, shotgunTxt, revolverTxt;


    private Skin skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));


    public static GameAssetManager getInstance() {
        if (instance == null) {
            instance = new GameAssetManager();
        }
        return instance;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }


    private final String bullet = "bullet.png";


    private GameAssetManager() {
        buildDasherAnimation();
        buildShanaAnimation();
        buildLilithAnimation();
        buildDiamondAnimation();
        buildScarletAnimation2();

        buildScarletWalkAnimation2();
        buildDiamondWalkAnimation();
        buildShanaWalkAnimation();
        buildLilithWalkAnimation();
        buildDasherWalkAnimation();

        buildWeapons();
    }

    public Animation<Texture> getHeroIdleAnimation() {
        String heroName = App.getInstance().getGameSetting().getHeroName();
        if (heroName.equalsIgnoreCase("Dasher")) {
            return dahserAnimation;
        } else if (heroName.equalsIgnoreCase("Diamond")) {
            return diamondAnimation;
        } else if (heroName.equalsIgnoreCase("Lilith")) {
            return lilithAnimation;
        } else if (heroName.equalsIgnoreCase("Scarlet")) {
            return scarletAnimation;
        } else if (heroName.equalsIgnoreCase("Shana")) {
            return shanaAnimation;
        }
        return null;
    }

    public Animation<Texture> getHeroWalkAnimation() {
        String heroName = App.getInstance().getGameSetting().getHeroName();
        if (heroName.equalsIgnoreCase("Dasher")) {
            return dahserWalkAnimation;
        } else if (heroName.equalsIgnoreCase("Diamond")) {
            return diamondWalkAnimation;
        } else if (heroName.equalsIgnoreCase("Lilith")) {
            return lilithWalkAnimation;
        } else if (heroName.equalsIgnoreCase("Scarlet")) {
            return scarletWalkAnimation;
        } else if (heroName.equalsIgnoreCase("Shana")) {
            return shanaWalkAnimation2;
        }
        return null;
    }

    public String getFirstIdle() {
        String heroName = App.getInstance().getGameSetting().getHeroName();
        if (heroName.equalsIgnoreCase("Dasher")) {
            return dasher0Path;
        } else if (heroName.equalsIgnoreCase("Diamond")) {
            return diamond0Path;
        } else if (heroName.equalsIgnoreCase("Lilith")) {
            return lilith0Path;
        } else if (heroName.equalsIgnoreCase("Scarlet")) {
            return scarlet0Path;
        } else if (heroName.equalsIgnoreCase("Shana")) {
            return shana0Path;
        }
        return null;
    }

    public Texture getWeapon() {
        if (App.getInstance().getGameSetting().getWeapon().equalsIgnoreCase("shotgun")) {
            return shotgunTxt;
        } else if (App.getInstance().getGameSetting().
            getWeapon().equalsIgnoreCase("revolver")) {
            return revolverTxt;
        } else if (App.getInstance().getGameSetting().getWeapon().equalsIgnoreCase("smgs dual")) {
            return smgTxt;
        }
        return null;
    }

    public String getBullet() {
        return bullet;
    }

    private static void buildShanaAnimation() {
        String shana0Path = "assets/Heros/Shana/idle/Idle_0 #8330.png";
        String shana1Path = "assets/Heros/Shana/idle/Idle_1 #8360.png";
        String shana2Path = "assets/Heros/Shana/idle/Idle_2 #8819.png";
        String shana3Path = "assets/Heros/Shana/idle/Idle_3 #8457.png";
        String shana4Path = "assets/Heros/Shana/idle/Idle_3 #8457.png";
        String shana5Path = "assets/Heros/Shana/idle/Idle_5 #8307.png";
        Texture shana0 = new Texture(shana0Path);
        Texture shana1 = new Texture(shana1Path);
        Texture shana2 = new Texture(shana2Path);
        Texture shana3 = new Texture(shana3Path);
        Texture shana4 = new Texture(shana4Path);
        Texture shana5 = new Texture(shana5Path);
        shanaAnimation = new Animation<>(0.1f,
            shana0, shana1, shana2, shana3, shana4, shana5);
    }

    private static void buildScarletAnimation2() {
        String scarlet0Path = "assets/Heros/Scarlet/idle/Idle_0 #8327.png";
        String scarlet1Path = "assets/Heros/Scarlet/idle/Idle_1 #8357.png";
        String scarlet2Path = "assets/Heros/Scarlet/idle/Idle_2 #8816.png";
        String scarlet3Path = "assets/Heros/Scarlet/idle/Idle_3 #8454.png";
        String scarlet4Path = "assets/Heros/Scarlet/idle/Idle_3 #8454.png";
        String scarlet5Path = "assets/Heros/Scarlet/idle/Idle_5 #8304.png";
        Texture scarlet0 = new Texture(scarlet0Path);
        Texture scarlet1 = new Texture(scarlet1Path);
        Texture scarlet2 = new Texture(scarlet2Path);
        Texture scarlet3 = new Texture(scarlet3Path);
        Texture scarlet4 = new Texture(scarlet4Path);
        Texture scarlet5 = new Texture(scarlet5Path);
        scarletAnimation = new Animation<>(0.1f,
            scarlet0, scarlet1, scarlet2, scarlet3, scarlet4, scarlet5);
    }

    private static void buildLilithAnimation() {
        String lilith0Path = "assets/Heros/Lilith/idle/Idle_0 #8333.png";
        String lilith1Path = "assets/Heros/Lilith/idle/Idle_1 #8363.png";
        String lilith2Path = "assets/Heros/Lilith/idle/Idle_2 #8822.png";
        String lilith3Path = "assets/Heros/Lilith/idle/Idle_3 #8460.png";
        String lilith4Path = "assets/Heros/Lilith/idle/Idle_4 #8321.png";
        String lilith5Path = "assets/Heros/Lilith/idle/Idle_5 #8310.png";
        Texture lilith0 = new Texture(lilith0Path);
        Texture lilith1 = new Texture(lilith1Path);
        Texture lilith2 = new Texture(lilith2Path);
        Texture lilith3 = new Texture(lilith3Path);
        Texture lilith4 = new Texture(lilith4Path);
        Texture lilith5 = new Texture(lilith5Path);
        lilithAnimation = new Animation<>(0.1f,
            lilith0, lilith1, lilith2, lilith3, lilith4, lilith5);
    }

    private static void buildDasherAnimation() {
        String dasher0Path = "assets/Heros/Dasher/idle/Idle_0 #8325.png";
        final String dasher1Path = "assets/Heros/Dasher/idle/Idle_1 #8355.png";
        final String dasher2Path = "assets/Heros/Dasher/idle/Idle_2 #8814.png";
        final String dasher3Path = "assets/Heros/Dasher/idle/Idle_3 #8452.png";
        final String dasher4Path = "assets/Heros/Dasher/idle/Idle_4 #8313.png";
        final String dasher5Path = "assets/Heros/Dasher/idle/Idle_5 #8302.png";
        final Texture dasher0 = new Texture(dasher0Path);
        final Texture dasher1 = new Texture(dasher1Path);
        final Texture dasher2 = new Texture(dasher2Path);
        final Texture dasher3 = new Texture(dasher3Path);
        final Texture dasher4 = new Texture(dasher4Path);
        final Texture dasher5 = new Texture(dasher5Path);
        dahserAnimation = new Animation<>(0.1f,
            dasher0, dasher1, dasher2, dasher3, dasher4, dasher5);
    }

    public static void buildDiamondAnimation() {
        final String diamond0Path = "assets/Heros/Diamond/idle/Idle_0 #8328.png";
        final String diamond1Path = "assets/Heros/Diamond/idle/Idle_1 #8358.png";
        final String diamond2Path = "assets/Heros/Diamond/idle/Idle_2 #8817.png";
        final String diamond3Path = "assets/Heros/Diamond/idle/Idle_3 #8455.png";
        final String diamond4Path = "assets/Heros/Diamond/idle/Idle_4 #8316.png";
        final String diamond5Path = "assets/Heros/Diamond/idle/Idle_5 #8305.png";
        final Texture diamond0 = new Texture(diamond0Path);
        final Texture diamond1 = new Texture(diamond1Path);
        final Texture diamond2 = new Texture(diamond2Path);
        final Texture diamond3 = new Texture(diamond3Path);
        final Texture diamond4 = new Texture(diamond4Path);
        final Texture diamond5 = new Texture(diamond5Path);
        diamondAnimation = new Animation<>(0.1f,
            diamond0, diamond1, diamond2, diamond3, diamond4, diamond5);
    }

    public static void buildDiamondWalkAnimation() {
        final String diamond0Path = "assets/Heros/Diamond/walk/Walk_0 #8277.png";
        final String diamond1Path = "assets/Heros/Diamond/walk/Walk_1 #8631.png";
        final String diamond2Path = "assets/Heros/Diamond/walk/Walk_2 #8710.png";
        final String diamond3Path = "assets/Heros/Diamond/walk/Walk_3 #8768.png";
        final String diamond4Path = "assets/Heros/Diamond/walk/Walk_4 #8464.png";
        final String diamond5Path = "assets/Heros/Diamond/walk/Walk_5 #8687.png";
        final String diamond6Path = "assets/Heros/Diamond/walk/Walk_6 #8441.png";
        final String diamond7Path = "assets/Heros/Diamond/walk/Walk_7 #8213.png";

        final Texture diamond0 = new Texture(diamond0Path);
        final Texture diamond1 = new Texture(diamond1Path);
        final Texture diamond2 = new Texture(diamond2Path);
        final Texture diamond3 = new Texture(diamond3Path);
        final Texture diamond4 = new Texture(diamond4Path);
        final Texture diamond5 = new Texture(diamond5Path);
        final Texture diamond6 = new Texture(diamond6Path);
        final Texture diamond7 = new Texture(diamond7Path);


        diamondWalkAnimation = new Animation<>(0.1f,
            diamond0, diamond1, diamond2, diamond3, diamond4, diamond5, diamond6, diamond7);
    }

    private static void buildScarletWalkAnimation2() {
        String scarlet0Path = "assets/Heros/Scarlet/run/Run_0 #8759.png";
        String scarlet1Path = "assets/Heros/Scarlet/run/Run_1 #8775.png";
        String scarlet2Path = "assets/Heros/Scarlet/run/Run_2 #8283.png";
        String scarlet3Path = "assets/Heros/Scarlet/run/Run_3 #8346.png";
        Texture scarlet0 = new Texture(scarlet0Path);
        Texture scarlet1 = new Texture(scarlet1Path);
        Texture scarlet2 = new Texture(scarlet2Path);
        Texture scarlet3 = new Texture(scarlet3Path);
        scarletWalkAnimation = new Animation<>(0.1f,
            scarlet0, scarlet1, scarlet2, scarlet3);
    }

    private static void buildDasherWalkAnimation() {
        String dasher0Path = "assets/Heros/Dasher/run/Run_0 #8757.png";
        final String dasher1Path = "assets/Heros/Dasher/run/Run_1 #8773.png";
        final String dasher2Path = "assets/Heros/Dasher/run/Run_2 #8281.png";
        final String dasher3Path = "assets/Heros/Dasher/run/Run_3 #8344.png";
        final Texture dasher0 = new Texture(dasher0Path);
        final Texture dasher1 = new Texture(dasher1Path);
        final Texture dasher2 = new Texture(dasher2Path);
        final Texture dasher3 = new Texture(dasher3Path);
        dahserWalkAnimation = new Animation<>(0.1f,
            dasher0, dasher1, dasher2, dasher3);
    }

    private static void buildLilithWalkAnimation() {
        String lilith0Path = "assets/Heros/Lilith/walk/Walk_0 #8279.png";
        String lilith1Path = "assets/Heros/Lilith/walk/Walk_1 #8633.png";
        String lilith2Path = "assets/Heros/Lilith/walk/Walk_1 #8633.png";
        String lilith3Path = "assets/Heros/Lilith/walk/Walk_3 #8770.png";
        String lilith4Path = "assets/Heros/Lilith/walk/Walk_4 #8465.png";
        String lilith5Path = "assets/Heros/Lilith/walk/Walk_5 #8689.png";
        String lilith6Path = "assets/Heros/Lilith/walk/Walk_6 #8443.png";
        String lilith7Path = "assets/Heros/Lilith/walk/Walk_7 #8215.png";
        Texture lilith0 = new Texture(lilith0Path);
        Texture lilith1 = new Texture(lilith1Path);
        Texture lilith2 = new Texture(lilith2Path);
        Texture lilith3 = new Texture(lilith3Path);
        Texture lilith4 = new Texture(lilith4Path);
        Texture lilith5 = new Texture(lilith5Path);
        Texture lilith6 = new Texture(lilith6Path);
        Texture lilith7 = new Texture(lilith7Path);
        lilithWalkAnimation = new Animation<>(0.1f,
            lilith0, lilith1, lilith2, lilith3, lilith4, lilith5, lilith6, lilith7);
    }

    private static void buildShanaWalkAnimation() {
        String shana0Path = "assets/Heros/Shana/walk/Walk_0 #8278.png";
        String shana1Path = "assets/Heros/Shana/walk/Walk_1 #8632.png";
        String shana2Path = "assets/Heros/Shana/walk/Walk_2 #8711.png";
        String shana3Path = "assets/Heros/Shana/walk/Walk_3 #8769.png";
        String shana4Path = "assets/Heros/Shana/walk/Walk_5 #8688.png";
        String shana5Path = "assets/Heros/Shana/walk/Walk_6 #8442.png";
        String shana6Path = "assets/Heros/Shana/walk/Walk_7 #8214.png";

        Texture shana0 = new Texture(shana0Path);
        Texture shana1 = new Texture(shana1Path);
        Texture shana2 = new Texture(shana2Path);
        Texture shana3 = new Texture(shana3Path);
        Texture shana4 = new Texture(shana4Path);
        Texture shana5 = new Texture(shana5Path);
        Texture shana6 = new Texture(shana6Path);

        shanaWalkAnimation2 = new Animation<>(0.1f,
            shana0, shana1, shana2, shana3, shana4, shana5, shana6);
    }

    public static void buildWeapons() {
        smgPath = "assets/Images/Sprite/SMGStill/SMGStill.png";
        shotgunPath = "assets/shotgun.png";
        revolverPath = "assets/Images/Sprite/RevolverStill/RevolverStill.png";
        smgTxt = new Texture(smgPath);
        shotgunTxt = new Texture(shotgunPath);
        revolverTxt = new Texture(revolverPath);
    }
}

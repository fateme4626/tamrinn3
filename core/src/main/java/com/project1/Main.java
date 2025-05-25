package com.project1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.project1.Controllers.MainMenuController;
import com.project1.Controllers.ProfileController;
import com.project1.Controllers.StartMenuController;
import com.project1.Models.GameAssetManager;
import com.project1.Views.MainMenu;
import com.project1.Views.ProfileMenuScreens.ChangeAvatarScreen;
import com.project1.Views.ProfileMenuScreens.ProfileMenu;
import com.project1.Views.StartMenu;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private static Main main;
    private static SpriteBatch batch;
   // private Texture image;

    @Override
    public void create() {
        main = this;
        batch = new SpriteBatch();
    //    image = new Texture("libgdx.png");
//        getInstance().setScreen(new SignUpMenu((new SignUpController()), GameAssetManager.getInstance().getSkin()));
        getInstance().setScreen(new StartMenu(new StartMenuController(), GameAssetManager.getInstance().getSkin()));

    }



    @Override
    public void render() {
//        //run per every frame
//        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
//        batch.begin();
//      //  batch.draw(image, 140, 210);
//        batch.end();
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
   //     image.dispose();
    }

    public static Main getInstance() {
        if (main == null) {
            main = new Main();
        }
        return main;
    }

    public static Batch getBatch() {
        return batch;
    }
}

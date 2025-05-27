package com.project1.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.GameControllers.GameController;
import com.project1.Controllers.MainMenuController;
import com.project1.Main;
import com.project1.Models.GameAssetManager;

public class PauseMenu implements Screen {
    private Stage stage;
    private Skin skin;
    private TextButton resumeBtn, endBtn;
    Table table;

    public PauseMenu() {
        this.skin = GameAssetManager.getInstance().getSkin();
        this.stage = new Stage();
        resumeBtn = new TextButton("Resume", skin);
        endBtn = new TextButton("Give Up", skin);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        table = new Table(skin);
        table.setFillParent(true);
        table.add(resumeBtn).left().pad(10);
        table.add(endBtn).right().pad(10);
        stage.addActor(table);

        resumeBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                resumeGame();
            }
        });
        endBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                endGame();
            }
        });
    }

    public void resumeGame() {
        Main.getInstance().getScreen().dispose();
        Main.getInstance().setScreen(new GameView(new GameController(), skin));
    }

    public void endGame() {
        Main.getInstance().getScreen().dispose();
        Main.getInstance().setScreen(new MainMenu(new MainMenuController(), skin));
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

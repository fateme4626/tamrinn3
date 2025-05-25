package com.project1.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.PreGameMenuController;
import com.project1.Main;

public class PreGameMenu implements Screen {
    private Stage stage;
    private Skin skin;
    private Label heroLabel, weaponLabel, timeLabel;
    private Table mainTable;
    private final SelectBox selectHero, selectWeapon, selectTime;
    private final TextButton startBtn, backBtn;
    private PreGameMenuController controller;

    public PreGameMenu(PreGameMenuController controller, Skin skin) {
        this.controller = controller;
        this.skin = skin;
        this.heroLabel = new Label("Hero", skin, "title");
        this.weaponLabel = new Label("Weapon", skin, "title");
        this.timeLabel = new Label("Time", skin, "title");
        this.mainTable = new Table();
        this.startBtn = new TextButton("Start", skin);
        controller.setView(this);
        this.backBtn = new TextButton("Back", skin);
        this.selectHero = new SelectBox(skin);
        this.selectTime = new SelectBox(skin);
        this.selectWeapon = new SelectBox(skin);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport()); //it makes a new stage
        Gdx.input.setInputProcessor(stage); //set an input processor for system to understand the inputs like click
        //up 2 lines should exist in all menu show functions for all menus

        mainTable.setFillParent(true);
        Array<String> heroes = new Array<>();
        heroes.add("Shana");
        heroes.add("Diamond");
        heroes.add("Scarlet");
        heroes.add("Lilith");
        heroes.add("Dasher");
        selectHero.setItems(heroes);

        selectWeapon.setItems("Revolver", "Shotgun", "SMGs Dual");


        selectTime.setItems(2, 5, 10, 20);

        mainTable.setFillParent(true);
        mainTable.center();

        mainTable.add(heroLabel).pad(10);
        mainTable.add(selectHero).width(700).pad(20).row();

        mainTable.add(weaponLabel).pad(10);
        mainTable.add(selectWeapon).width(700).pad(20).row();

        mainTable.add(timeLabel).pad(10);
        mainTable.add(selectTime).width(700).pad(20).row();
        mainTable.row().spaceTop(30);
        mainTable.row().spaceTop(30);
        mainTable.add(startBtn).center().row();
        mainTable.row().spaceTop(30);
        mainTable.row().spaceTop(30);
        mainTable.add(backBtn).center().row();

        backBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.goBack();
            }
        });

        startBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.startGame();
            }
        });

        stage.addActor(mainTable);
    }


    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 1);//background with RGB
        Main.getBatch().begin();//we don't have sprite yet, so we don't have anything between begin and end
        Main.getBatch().end();
        stage.act(Math.max(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw(); //render the stage
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

    public SelectBox getSelectHero() {
        return selectHero;
    }
    public SelectBox getSelectWeapon() {
        return selectWeapon;
    }
    public SelectBox getSelectTime() {
        return selectTime;
    }

}

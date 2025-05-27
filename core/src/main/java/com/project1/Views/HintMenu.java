package com.project1.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.MainMenuController;
import com.project1.Main;
import com.project1.Models.Enums.Hero;

public class HintMenu implements Screen {
    private Stage stage;
    private Skin skin;
    private Table mainTable;
    private ScrollPane scrollPane;

    public HintMenu(Skin skin) {
        this.skin = skin;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table contentTable = new Table();
        contentTable.defaults().pad(20).width(stage.getWidth() - 50);

        contentTable.add(new Label("Game Basics", skin, "title")).row();
        contentTable.add(showHints()).growX().row();

        contentTable.add(new Label("Heroes", skin, "title")).center().padTop(50).row();
        contentTable.add(fillHeroTable()).growX().row();

        scrollPane = new ScrollPane(contentTable, skin);
        scrollPane.setScrollingDisabled(true, false);
        scrollPane.setFadeScrollBars(false);
        scrollPane.setScrollBarTouch(true);

        TextButton backButton = new TextButton("Back", skin);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().getScreen().dispose();
                Main.getInstance().setScreen(new MainMenu(new MainMenuController(), skin));
            }
        });

        mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.add(scrollPane).grow();
        mainTable.row();
        mainTable.add(backButton).pad(20);

        stage.addActor(mainTable);
    }

    private Table showHints() {
        Table basics = new Table();
        basics.defaults().pad(10).left();

        String[] hints = {
            "+ Movement: W-A-S-D",
            "+ Shooting: Left mouse click",
            "+ Reload: R key",
            "+ Pause: P key"
        };

        for (String hint : hints) {
            basics.add(new Label(hint, skin)).row();
        }

        return basics;
    }

    private Table fillHeroTable() {
        Table heroesTable = new Table();
        heroesTable.defaults().pad(20);

        for (Hero hero : Hero.values()) {
            heroesTable.add(createHeroCard(hero)).width(300).row();
        }

        return heroesTable;
    }

    private Table createHeroCard(Hero hero) {
        Table card = new Table();
        card.pad(15);

        Image img = new Image(new Texture(hero.getPath()));
        img.setScaling(Scaling.fit);
        card.add(img).size(120, 120).row();

        card.add(new Label(hero.getName(), skin, "subtitle")).padTop(10).row();
        card.add(new Label("Speed: " + hero.getSpeed(), skin)).row();
        card.add(new Label("HP: " + hero.getHP(), skin)).row();

        return card;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
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


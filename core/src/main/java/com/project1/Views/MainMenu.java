package com.project1.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.MainMenuController;
import com.project1.Main;
import com.project1.Models.App;


public class MainMenu implements Screen {
    private Stage stage;
    private final TextButton profileButton;
    private final TextButton settingsButton;
    private final TextButton playButton;
    private final TextButton hintMenuButton;
    private final TextButton scoreBoardButton;
    private final TextButton preGameButton;
    private final Label playLabel;
    public Table table;
    public Table mainTable;
    public Table topTable;
    Table downTable;
    Label nameLabel;
    private Image avatarImage;
    private final MainMenuController mainController;

    public MainMenu(MainMenuController mainController, Skin skin) {
        this.mainController = mainController;
        this.mainTable = new Table();
        table = new Table();
        topTable = new Table();
        downTable = new Table();
        mainTable = new Table();
        this.profileButton = new TextButton("Profile", skin);
        this.playLabel = new Label("Hi! Welcome to till dawn", skin);
        this.settingsButton = new TextButton("Settings", skin);
        this.playButton = new TextButton("Play", skin);
        this.hintMenuButton = new TextButton("HintMenu", skin);
        this.scoreBoardButton = new TextButton("ScoreBoard", skin);
        this.preGameButton = new TextButton("PreGameMenu", skin);
        nameLabel = new Label(App.getInstance().getPlayerProfile().getUsername(), skin);
        Texture avatarTexture = new Texture(Gdx.files.internal(App.getInstance().getPlayerProfile().getAvatarPath()));
        avatarImage = new Image(avatarTexture);
        avatarImage.setScaling(Scaling.fit);

        mainController.setView(this);
    }

    @Override
    //when a menu opens , first of all system runs the show function
    public void show() {
        stage = new Stage(new ScreenViewport()); //it makes a new stage
        Gdx.input.setInputProcessor(stage); //set an input processor for system to understand the inputs like click
        //up 2 lines should exist in all menu show functions for all menus

        table.setFillParent(true);
        // topTable.setFillParent(true);
        topTable.add(profileButton).left().pad(10);
        topTable.add().expandX(); // Push buttons apart
        topTable.add(settingsButton).right().pad(10);

        // Configure bottom table
        downTable.add(preGameButton).left().pad(10);
        downTable.add().expandX();
        downTable.add(hintMenuButton).right().pad(10);

        mainTable.defaults().width(400).padBottom(15);
        mainTable.add(playLabel).padBottom(30).row();
        mainTable.row().spaceTop(30);
        mainTable.add(playButton).row();
        mainTable.add(scoreBoardButton).row();
        Table rightTable = new Table();
        rightTable.defaults().right().pad(10);
        rightTable.add(nameLabel).row();
        rightTable.add(avatarImage).size(100, 100);
        mainTable.add(rightTable).expandX().right().row();
        table.add(topTable).top().growX().row();
        table.add(mainTable).center().expand().grow().row();
        table.add(downTable).bottom().growX().row();


        stage.addActor(table); //all stages need actor
        //we can add all of these elements to stage directly instead of adding to table
        //like bottom
//        stage.addActor(mainButton);
//        mainButton.setPosition(stage.getWidth() / 2, stage.getHeight() / 2);
        //but we use table now
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 / 255f, 40 / 255f, 53 / 255f, 1); //background with RGB
        Main.getBatch().begin();//we don't have sprite yet, so we don't have anything between begin and end
        Main.getBatch().end();
        stage.act(Math.max(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw(); //render the stage
        mainController.handleMainMenuButton();
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

    public TextButton getMainButton() {
        return settingsButton;
    }

    public TextButton getPreGameButton() {
        return preGameButton;
    }

    public TextButton getHintMenuButton() {
        return hintMenuButton;
    }

    public TextButton getScoreBoardButton() {
        return scoreBoardButton;
    }

    public TextButton getPlayButton() {
        return playButton;
    }

    public TextButton getProfileButton() {
        return profileButton;
    }

    public TextButton getSettingsButton() {
        return settingsButton;
    }
}

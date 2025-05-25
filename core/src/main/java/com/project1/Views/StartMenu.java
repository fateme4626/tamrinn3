package com.project1.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.MainMenuController;
import com.project1.Controllers.StartMenuController;
import com.project1.Main;
import com.project1.Models.App;

public class StartMenu implements Screen {
    private Stage stage;
    private final TextButton signUpButton;
    private final TextButton loginButton;
    private final TextButton signInAsGuestButton;
    private final Label label1;
    public Table table;
    Table downTable;
    private Image avatarImage;
    private final StartMenuController controller;

    public StartMenu(StartMenuController controller, Skin skin) {
        this.controller = controller;
        controller.setView(this);
        this.signUpButton = new TextButton("Sign Up", skin);
        this.loginButton = new TextButton("Login", skin);
        this.signInAsGuestButton = new TextButton("Continue As Guest", skin);
        this.label1 = new Label("Hi! welcome to the game", skin);
        this.table = new Table();
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport()); //it makes a new stage
        Gdx.input.setInputProcessor(stage);

        table.setFillParent(true);
        table.add(label1).top().expandX().row();
        table.row().pad(20, 0, 20, 0);
        table.add(signUpButton).row();
        table.row().pad(20, 0, 20, 0);
        table.add(loginButton).row();
        table.row().pad(20, 0, 20, 0);
        table.add(signInAsGuestButton).row();
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 / 255f, 40 / 255f, 53 / 255f, 1); //background with RGB
        Main.getBatch().begin();//we don't have sprite yet, so we don't have anything between begin and end
        Main.getBatch().end();
        stage.act(Math.max(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw(); //render the stage
        controller.handleMainMenuButton();
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

    public TextButton getSignUpButton() {
        return signUpButton;
    }

    public TextButton getLoginButton() {
        return loginButton;
    }

    public TextButton getSignInAsGuestButton() {
        return signInAsGuestButton;
    }
}

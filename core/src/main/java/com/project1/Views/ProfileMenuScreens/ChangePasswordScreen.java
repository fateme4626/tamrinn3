package com.project1.Views.ProfileMenuScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.ProfileController;
import com.project1.Main;

public class ChangePasswordScreen implements Screen {
    private Stage stage;
    private final TextButton confirmButton;
    private final TextField newPasswordField;
    TextButton backButton;
    public Table table;
    Label label;
    private ProfileController controller;

    public ChangePasswordScreen(ProfileController controller, Skin skin) {
        this.controller = controller;
        this.table = new Table();
        backButton = new TextButton("Back", skin);
        this.label = new Label("Please Enter Your New Password", skin);
        this.confirmButton = new TextButton("Confirm", skin);
        this.newPasswordField = new TextField("", skin);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport()); //it makes a new stage
        Gdx.input.setInputProcessor(stage); //set an input processor for system to understand the inputs like click
        //up 2 lines should exist in all menu show functions for all menus

        table.setFillParent(true);
        // Configure main content table
        table.center(); //align table to center of page
        table.add(label);
        table.row().pad(20, 0, 20, 0);
        table.add(newPasswordField).width(700);
        table.row().pad(20, 0, 20, 0);
        table.add(confirmButton);
        table.row().pad(20, 0, 20, 0);
        table.row().pad(20, 0, 20, 0);
        table.add(backButton);
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 / 255f, 40 / 255f, 53 / 255f, 1);   // #002835
        Main.getBatch().begin();//we don't have sprite yet, so we don't have anything between begin and end
        Main.getBatch().end();
        stage.act(Math.max(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw(); //render the stage
        controller.handleChangePassword(this);
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

    public TextButton getConfirmButton() {
        return confirmButton;
    }

    public TextField getNewPasswordField() {
        return newPasswordField;
    }

    public TextButton getBackButton() {
        return backButton;
    }

}

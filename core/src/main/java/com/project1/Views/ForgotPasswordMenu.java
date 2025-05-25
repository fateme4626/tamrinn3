package com.project1.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.LoginMenuController;
import com.project1.Main;

public class ForgotPasswordMenu implements Screen {
    private Stage stage;
    private final TextButton loginButton;
    private final TextButton backButton;
    private final TextField usernameField;
    private final TextField securityQuestionField;
    public Table centerTable;
    public Table bottomTable;
    Table firstTable;
    public Table secondTable;
    private final LoginMenuController controller;

    public ForgotPasswordMenu(LoginMenuController controller, Skin skin) {
        this.controller = controller;
        this.centerTable = new Table();
        this.firstTable = new Table();
        this.secondTable = new Table();
        this.bottomTable = new Table();
        this.loginButton = new TextButton("Login", skin);
        this.backButton = new TextButton("Back", skin);
        this.securityQuestionField = new TextField("What is your father's name?", skin);
        this.usernameField = new TextField("enter your username", skin);
      //  controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport()); //it makes a new stage
        Gdx.input.setInputProcessor(stage); //set an input processor for system to understand the inputs like click
        //up 2 lines should exist in all menu show functions for all menus

        centerTable.setFillParent(true);
        // Configure main content table
        centerTable.center(); //align table to center of page
        centerTable.row().pad(20, 0, 20, 0);
        centerTable.add(usernameField).width(700);
        centerTable.row().pad(20, 0, 20, 0);
        centerTable.add(securityQuestionField).width(700);
        centerTable.row().pad(20, 0, 20, 0);
        centerTable.add(loginButton);
        centerTable.row().pad(20, 0, 20, 0);
        centerTable.add(backButton);

        stage.addActor(centerTable);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 / 255f, 40 / 255f, 53 / 255f, 1);   // #002835
        Main.getBatch().begin();//we don't have sprite yet, so we don't have anything between begin and end
        Main.getBatch().end();
        stage.act(Math.max(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw(); //render the stage
        controller.handleForgotPasswordButton(this);
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

    public TextButton getLoginButton() {
        return loginButton;
    }
    public TextButton getBackButton() {
        return backButton;
    }
    public TextField getUsernameField() {
        return usernameField;
    }
    public TextField getSecurityQuestionField() {
        return securityQuestionField;
    }
}

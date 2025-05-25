package com.project1.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.LoginMenuController;
import com.project1.Main;

public class LoginMenu implements Screen {
    private Stage stage;
    private final TextButton loginButton;
    private final TextButton backButton;
    private final TextButton forgotPasswordButton;
    private final TextField passwordField;
    private final TextField usernameField;
    public Table centerTable;
    public Table bottomTable;
    Table firstTable;
    public Table secondTable;
    private final LoginMenuController controller;

    public LoginMenu(LoginMenuController controller, Skin skin) {
        this.controller = controller;
        this.centerTable = new Table();
        this.firstTable = new Table();
        this.secondTable = new Table();
        this.bottomTable = new Table();
        this.loginButton = new TextButton("Login", skin);
        this.backButton = new TextButton("Back", skin);
        this.forgotPasswordButton = new TextButton("Forgot Password", skin);
        this.passwordField = new TextField("password", skin);
        this.usernameField = new TextField("username", skin);
        controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport()); //it makes a new stage
        Gdx.input.setInputProcessor(stage); //set an input processor for system to understand the inputs like click
        //up 2 lines should exist in all menu show functions for all menus

        firstTable.setFillParent(true);

        bottomTable.add(backButton).left().pad(10);
        bottomTable.add().expandX(); // Push buttons apart
        bottomTable.add(forgotPasswordButton).left().pad(10);

        // Configure main content table
        centerTable.center(); //align table to center of page
        centerTable.row().pad(20, 0, 20, 0);
        centerTable.add(usernameField).width(700);
        centerTable.row().pad(20, 0, 20, 0);
        centerTable.add(passwordField).width(700);
        centerTable.row().pad(20, 0, 20, 0);
        centerTable.add(loginButton);


        // Assemble the root table
        firstTable.add(centerTable).center().expand().row(); // Main content
        firstTable.add(bottomTable).bottom().growX().row(); // Bottom section


        stage.addActor(firstTable);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 / 255f, 40 / 255f, 53 / 255f, 1);   // #002835
        Main.getBatch().begin();//we don't have sprite yet, so we don't have anything between begin and end
        Main.getBatch().end();
        stage.act(Math.max(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw(); //render the stage
        controller.handleMenuButton();
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

    public TextButton getForgotPasswordButton() {
        return forgotPasswordButton;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

}

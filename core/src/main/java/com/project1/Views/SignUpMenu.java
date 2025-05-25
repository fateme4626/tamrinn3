package com.project1.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.SignUpController;
import com.project1.Main;

public class SignUpMenu implements Screen {
    private Stage stage;
    private final TextButton signButton;
    private final TextButton backButton;
    private final Label mainLabel;
    private final TextField passwordField;
    private final TextField usernameField;
    private final TextField securityQuestion;
    private final Label securityLabel;
    public Table mainTable;
    private final SignUpController controller;

    public SignUpMenu(SignUpController controller, Skin skin) {
        this.controller = controller;
        this.mainTable = new Table();
        this.signButton = new TextButton("Sign Up", skin);
        this.mainLabel = new Label("please enter your information to getting start", skin);
        this.passwordField = new TextField("password", skin);
        this.usernameField = new TextField("username", skin);
        this.securityQuestion = new TextField("", skin);
        this.securityLabel = new Label("Security Question: What is your father's name?", skin);
        this.backButton = new TextButton("Back", skin);
        controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport()); //it makes a new stage
        Gdx.input.setInputProcessor(stage);

        mainTable.setFillParent(true);
        mainTable.center(); //align table to center of page
        mainTable.row().pad(20, 0, 20, 0);
        mainTable.add(mainLabel);
        mainTable.row().pad(20, 0, 20, 0);
        mainTable.add(usernameField).width(700);
        mainTable.row().pad(20, 0, 20, 0);
        mainTable.add(passwordField).width(700);
        mainTable.row().pad(20, 0, 20, 0);
        mainTable.add(securityLabel);
        mainTable.row().pad(20, 0, 20, 0);
        mainTable.add(securityQuestion).width(700);
        mainTable.row().pad(20, 0, 20, 0);
        mainTable.add(signButton);
        mainTable.row().pad(10, 10, 10, 10);
        mainTable.add(backButton);

        stage.addActor(mainTable);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 / 255f, 40 / 255f, 53 / 255f, 1);   // #002835
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

    public TextButton getSignButton() {
        return signButton;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public TextField getSecurityQuestion() {
        return securityQuestion;
    }

    public Label getMainLabel() {
        return mainLabel;
    }

    public void removeActor() {
        mainTable.removeActor(securityLabel);
        mainTable.removeActor(securityQuestion);
        mainTable.removeActor(usernameField);
        mainTable.removeActor(passwordField);
        mainTable.removeActor(signButton);
        mainLabel.invalidate();
    }

    public TextButton getBackButton() {
        return backButton;
    }
}

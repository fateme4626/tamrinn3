package com.project1.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.GuestSignInController;
import com.project1.Main;

public class ContinueAsGuestMenu implements Screen {
    private Stage stage;
    private final TextButton confirmButton;
    private final TextButton backButton;
    private final Label mainLabel;
    Table table;
    private final TextField usernameField;
    private final GuestSignInController controller;

    public ContinueAsGuestMenu(GuestSignInController controller, Skin skin) {
        this.controller = controller;
        this.mainLabel = new Label("Please enter your name", skin);
        this.confirmButton = new TextButton("Confirm", skin);
        this.backButton = new TextButton("Back", skin);
        this.usernameField = new TextField("your name", skin);
        table = new Table();
        controller.setView(this);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport()); //it makes a new stage
        Gdx.input.setInputProcessor(stage);

        table.setFillParent(true);
        table.center(); //align table to center of page
        table.row().pad(20, 0, 20, 0);
        table.add(mainLabel);
        table.row().pad(20, 0, 20, 0);
        table.add(usernameField).width(700);
        table.row().pad(20, 0, 20, 0);
        table.add(confirmButton);
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

    public TextButton getConfirmButton() {
        return confirmButton;
    }
    public TextButton getBackButton() {
        return backButton;
    }
    public TextField getUsernameField() {
        return usernameField;
    }
}

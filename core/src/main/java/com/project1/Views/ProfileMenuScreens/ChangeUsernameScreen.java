package com.project1.Views.ProfileMenuScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.ProfileController;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.project1.Main;


import java.awt.*;

public class ChangeUsernameScreen implements Screen {
    private Stage stage;
    private TextField newNameField;
    private TextButton confirmButton;
    private TextButton backButton;
    private Label label;
    private Table table;
    private ProfileController controller;
//    private Dialog dialog;

    public ChangeUsernameScreen(ProfileController controller, Skin skin) {
        this.controller = controller;
        this.table = new Table();
        this.label = new Label("Enter your new username", skin);
        this.newNameField = new TextField("", skin);
        this.confirmButton = new TextButton("Confirm", skin);
        this.backButton = new TextButton("Back", skin);
//        this.dialog = new Dialog("ERROR", skin);
//        this.dialog.getTitleLabel().setAlignment(Align.center); // تراز عنوان
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table.setFillParent(true);
        table.add(label);
        table.row().pad(20, 0, 20, 0);
        table.add(newNameField).width(700);
        table.row().pad(20, 0, 20, 0);
        table.add(confirmButton);
        table.row().pad(20, 0, 20, 0);
        table.add(backButton);
        stage.addActor(table);

        confirmButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 / 255f, 40 / 255f, 53 / 255f, 1); // #002835
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        controller.handleChangeUsername(this);
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
        Gdx.input.setInputProcessor(null);
        stage.dispose();
    }

    @Override
    public void dispose() {

    }

    // ... سایر متدها (resize, pause, resume, dispose)

    public TextButton getBackButton() {
        return backButton;
    }

    public TextButton getConfirmButton() {
        return confirmButton;
    }

    public TextField getNewNameField() {
        return newNameField;
    }

//    public void showError(String message) {
//        Skin skin = new Skin(Gdx.files.internal("assets/skin/pixthulhu-ui.json"));
//        Dialog dialog = new Dialog("Warning", skin, "error") {
//            public void result(Object obj) {
//                System.out.println("result " + obj);
//            }
//        };
//        dialog.text(message);
//        dialog.button("Ok", true); //sends "true" as the result
//        dialog.show(stage);
//    }

    public void removeActors() {
        table.removeActor(newNameField);
        table.removeActor(confirmButton);
        label.setText("your username changed to: " + newNameField.getText() +"!");
        table.invalidate();
    }
}


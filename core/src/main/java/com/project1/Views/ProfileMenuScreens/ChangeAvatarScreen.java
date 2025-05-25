// ChangeAvatarScreen.java
package com.project1.Views.ProfileMenuScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.ProfileController;
import com.project1.Main;
import com.project1.Models.App;
import com.project1.Models.Profile.DefaultAvatarsLoader;

import java.awt.*;


public class ChangeAvatarScreen implements Screen {
    private Stage stage;
    private Skin skin;
    private Table avatarsTable;
    private Image currentAvatar;
    Table leftTable;
    private Table mainTable;
    private ProfileController controller;
    TextButton confirmButton;
    TextButton backButton;
    String avatarPath;
    private Array<String> defaultAvatars;
    TextButton uploadBtn;

    public ChangeAvatarScreen(ProfileController controller, Skin skin) {
        this.controller = controller;
        this.skin = skin;
        mainTable = new Table();
        mainTable.setFillParent(true);
        avatarsTable = new Table();
        avatarPath = App.getInstance().getPlayerProfile().getAvatarPath();
        confirmButton = new TextButton("Change", skin);
        backButton = new TextButton("Back", skin);
        uploadBtn = new TextButton("Upload Avatar", skin);
        this.defaultAvatars = DefaultAvatarsLoader.getInstance().getAvatarPaths();
        currentAvatar = new Image(new Texture(Gdx.files.internal(
            App.getInstance().getPlayerProfile().getAvatarPath()
        )));
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        fillAvatarTable();
        uploadBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showUploadWindow();
            }
        });
        confirmButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.handleChangeAvatar(avatarPath);
            }
        });
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.goBack();
            }
        });
        mainTable.top().pad(30);
        mainTable.center();
        mainTable.add(currentAvatar).size(250, 250).padBottom(40).row();
        mainTable.row().spaceTop(30);
        mainTable.add(avatarsTable).growX().row();
        mainTable.row().spaceTop(30);
        Table buttonTable = new Table();
        buttonTable.add(backButton).pad(10);
        buttonTable.add(uploadBtn).pad(10);
        buttonTable.add(confirmButton).pad(10);
        mainTable.add(buttonTable).padTop(20);
        stage.addActor(mainTable);
    }

    private void showUploadWindow() {
            FileDialog fd = new FileDialog((java.awt.Frame) null, "choose avatar", FileDialog.LOAD );
            fd.setDirectory((System.getProperty("user.home") + "/Pictures"));
            fd.setFilenameFilter((dir, name) -> name.toLowerCase().matches(".*\\.(png|jpg|jpeg)$"));
            fd.setVisible(true);
            String selectedFile = fd.getFile();
            if(selectedFile != null) {
                String filePath = fd.getDirectory() + selectedFile;
                selectCustomAvatar(Gdx.files.absolute(filePath));
            }
    }

    private void fillAvatarTable() {
        avatarsTable.clear();
        for (String path : defaultAvatars) {
            ImageButton avatarBtn = avatarMaker(path);
            avatarsTable.add(avatarBtn).size(100, 100).pad(10);
        }
    }

    private ImageButton avatarMaker(String path) {
        Texture texture = new Texture(Gdx.files.internal(path));
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.imageUp = new TextureRegionDrawable(new TextureRegion(texture));
        ImageButton button = new ImageButton(style);
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                currentAvatar.setDrawable(new TextureRegionDrawable(new Texture(path)));
                avatarPath = path;
            }
        });
        return button;
    }
    private void selectCustomAvatar(FileHandle file) {
        try {
            FileHandle saveCustoms = Gdx.files.local("assets/avatar/customAvatars/");
            if (!saveCustoms.exists()) saveCustoms.mkdirs();
            FileHandle customFile = saveCustoms.child(file.name());
            //store all new custom avatars in a folder
            file.copyTo(customFile);
            currentAvatar.setDrawable(new TextureRegionDrawable(new Texture(customFile.path())));
            avatarPath = customFile.path();
        } catch (Exception e) {
            Gdx.app.error("File Error", "can not upload picture", e);
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0 / 255f, 40 / 255f, 53 / 255f, 1); //background with RGB
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.max(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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

}

package com.project1.Views.ProfileMenuScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.ProfileController;
import com.project1.Main;

public class ProfileMenu implements Screen {
    private Stage stage;
    private TextButton changeUserNameButton;
    private TextButton changePasswordButton;
    private TextButton changeAvatarButton;
    private TextButton deleteAccountButton;
    private TextButton logoutButton;
    private TextButton backButton;
    private Table table;
    private ProfileController controller;

    public ProfileMenu(ProfileController controller, Skin skin) {
        this.controller = controller;
        table = new Table(skin);
        table.setFillParent(true);
        deleteAccountButton = new TextButton("Delete Account", skin);
        changeAvatarButton = new TextButton("Change Avatar", skin);
        changePasswordButton = new TextButton("Change Password", skin);
        changeUserNameButton = new TextButton("Change UserName", skin);
        logoutButton = new TextButton("Logout", skin);
        backButton = new TextButton("Back", skin);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.center();
        table.add(changeUserNameButton).row();
        table.row().pad(20,0,20,0);
        table.add(changePasswordButton).row();
        table.row().pad(20,0,20,0);
        table.add(changeAvatarButton).row();
        table.row().pad(20,0,20,0);
        table.add(logoutButton).row();
        table.row().pad(20,0,20,0);
        table.add(deleteAccountButton).row();
        table.row().pad(20,0,20,0);
        table.add(backButton).row();
        table.row().pad(20,0,20,0);
        stage.addActor(table);

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 / 255f, 40 / 255f, 53 / 255f, 1);   // #002835
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.max(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        controller.handleProfileMenu(this);
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

    public TextButton getChangeUserNameButton() {
        return changeUserNameButton;
    }

    public TextButton getChangePasswordButton() {
        return changePasswordButton;
    }

    public TextButton getChangeAvatarButton() {
        return changeAvatarButton;
    }

    public TextButton getDeleteAccountButton() {
        return deleteAccountButton;
    }

    public TextButton getBackButton() {
        return backButton;
    }

    public TextButton getLogoutButton() {
        return logoutButton;
    }
}

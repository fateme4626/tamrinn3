package com.project1.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.project1.Controllers.SettingController;
import com.project1.Models.App;

public class SettingMenu implements Screen {
    private Stage stage;
    private Skin skin;
    private Table mainTable;
    private Label musicVolumeLabel, sfxVolumeLabel;
    private SettingController controller;
    private TextButton backButton, saveSettingsButton;
    private Slider musicVolume, sfxVolume;
    private CheckBox sfxCheckBox, autoReloadCheckBox, grayscaleCheckBox;
    private TextButton changeControlsKeysButton;

    public SettingMenu(SettingController controller, Skin skin) {
        this.controller = controller;
        this.skin = skin;
        mainTable = new Table();
        saveSettingsButton = new TextButton("Save Settings", skin);
        backButton = new TextButton("Back", skin);
        sfxVolumeLabel = new Label("SFX Volume", skin);
        musicVolumeLabel = new Label("Music Volume", skin);
        controller.setView(this);
    }



    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        mainTable.setFillParent(true);
        musicVolume = new Slider(0, 1, 0.1f, false, skin);
        musicVolume.setValue(App.getInstance().getGameSetting().getMusicVolume());
        mainTable.add(musicVolumeLabel).pad(10);
        mainTable.add(musicVolume).width(400).pad(20).row();
        sfxVolume = new Slider(0, 1, 0.1f, false, skin);
        sfxVolume.setValue(App.getInstance().getGameSetting().getSfxVolume());
        sfxCheckBox = new CheckBox("Enable SFX", skin);

        sfxCheckBox.setChecked(App.getInstance().getGameSetting().isSfxIsEnabled());
        mainTable.add(sfxVolumeLabel).pad(10);
        mainTable.add(sfxVolume).width(400).pad(20).row();
        mainTable.add(sfxCheckBox).colspan(2).pad(10).row();
        changeControlsKeysButton = new TextButton("Change Controls Keys", skin);
        autoReloadCheckBox = new CheckBox("Auto Reload", skin);
        autoReloadCheckBox.setChecked(App.getInstance().getGameSetting().isAutoReload());
        grayscaleCheckBox = new CheckBox("Grayscale Mode", skin);
        grayscaleCheckBox.setChecked(App.getInstance().getGameSetting().isGrayscaleMode());
        mainTable.add(autoReloadCheckBox).colspan(2).pad(10).row();
        mainTable.add(grayscaleCheckBox).colspan(2).pad(10).row();
        mainTable.add(changeControlsKeysButton).colspan(2).pad(10).row();
        mainTable.add(saveSettingsButton).colspan(2).pad(20).row();
        mainTable.add(backButton).colspan(2).pad(10).row();
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.goBack();
            }
        });
        saveSettingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.saveSetting();
            }
        });

        changeControlsKeysButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });

        stage.addActor(mainTable);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1);
        stage.act(delta);
        stage.draw();
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

    public Slider getMusicVolumeSlider() {
        return musicVolume;
    }
    public Slider getSfxVolumeSlider() {
        return sfxVolume;
    }
    public CheckBox getSfxCheckBox() {
        return sfxCheckBox;
    }
    public TextButton getChangeControlsKeysButton() {
        return changeControlsKeysButton;
    }
    public CheckBox getAutoReloadButton() {
        return autoReloadCheckBox;
    }
    public CheckBox getGrayscaleButton() {
        return grayscaleCheckBox;
    }
}


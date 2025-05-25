// CustomFileChooser.java
package com.project1.Views.ProfileMenuScreens;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CustomFileChooser extends Window {
    private FileHandle currentDir;
    private Skin skin;
    private FileChooserListener listener;
    private ScrollPane scrollPane;

    public CustomFileChooser(String title, Skin skin, FileHandle startDir) {
        super(title, skin);
        this.skin = skin;
        this.currentDir = startDir;
        setupUI();
    }

    private void setupUI() {
        setModal(true);
        setMovable(true);
        setKeepWithinStage(true); // این خط از خروج پنجره از Stage جلوگیری میکند
        pad(15);
        defaults().pad(5);

        Table header = new Table();
        TextButton upButton = new TextButton("..", skin);
        upButton.addListener(new ClickListener() {
            @Override public void clicked(InputEvent event, float x, float y) {
                navigateUp();
            }
        });
        header.add(new Label("path: " + currentDir.path(), skin)).expandX().left();
        header.add(upButton).width(50);
        add(header).colspan(2).fillX().row();

        Table fileTable = new Table();
        scrollPane = new ScrollPane(fileTable, skin);
        add(scrollPane).colspan(2).grow().row();

        // پاورقی
        TextButton cancelButton = new TextButton("cancel", skin);
        cancelButton.addListener(new ClickListener() {
            @Override public void clicked(InputEvent event, float x, float y) {
                remove();
            }
        });
        add(cancelButton).right();

        refreshFileList();
        pack();
        setSize(getWidth() + 50, getHeight() + 50); // اضافه کردن حاشیه امن
    }

    private void refreshFileList() {
        Table fileTable = ((Table) scrollPane.getActor());
        fileTable.clear();

        for(FileHandle file : currentDir.list()) {
            if(file.isDirectory() || isImageFile(file)) {
                TextButton btn = new TextButton(getFileDisplayName(file), skin);
                btn.addListener(new ClickListener() {
                    @Override public void clicked(InputEvent event, float x, float y) {
                        handleFileSelected(file);
                    }
                });
                fileTable.add(btn).growX().left().row();
            }
        }
    }

    private boolean isImageFile(FileHandle file) {
        String ext = file.extension().toLowerCase();
        return ext.matches("png");
    }

    private String getFileDisplayName(FileHandle file) {
        return file.isDirectory() ? "[D] " + file.name() : "[F] " + file.name();
    }

    private void navigateUp() {
        if(currentDir.parent() != null) {
            currentDir = currentDir.parent();
            refreshFileList();
        }
    }

    private void handleFileSelected(FileHandle file) {
        if(file.isDirectory()) {
            currentDir = file;
            refreshFileList();
        } else {
            if(listener != null) listener.selected(file);
            remove();
        }
    }

    public void setListener(FileChooserListener listener) {
        this.listener = listener;
    }


    public void dispose() {
        clear();
    }

    public interface FileChooserListener {
        void selected(FileHandle file);
    }
}

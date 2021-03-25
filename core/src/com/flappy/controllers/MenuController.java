package com.flappy.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.flappy.App;
import com.flappy.utils.ObjectPositionChecker;

public class MenuController implements Screen {

    protected final App app;
    private final ObjectController backgroundObjectController;
    private final ObjectController playButtonObjectController;
    private final float height;
    private final float width;

    public MenuController(App app, float width, float height) {
        this.app = app;
        this.height = height;
        this.width = width;

        this.backgroundObjectController = new ObjectController(0, 0, this.width, this.height);

        float xButtonPosition = width / 2 - (float) this.app.playButton.getWidth() / 2;
        float yButtonPosition = height / 2 - (float) this.app.playButton.getHeight() / 2;
        this.playButtonObjectController = new ObjectController(xButtonPosition, yButtonPosition,
                this.app.playButton.getWidth(), this.app.playButton.getHeight());


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.app.batch.begin();
        this.app.batch.draw(this.app.background, this.backgroundObjectController.getXPosition(), this.backgroundObjectController.getYPosition(),
                this.backgroundObjectController.getWidth(), this.backgroundObjectController.getHeight());
        this.app.batch.draw(this.app.playButton, this.playButtonObjectController.getXPosition(), this.playButtonObjectController.getYPosition());
        this.app.batch.end();

        float xMouse = Gdx.input.getX();
        float yMouse = height - Gdx.input.getY();
        ObjectController mouseObjectController = new ObjectController(xMouse, yMouse, 0, 0);
        ObjectPositionChecker ObjectPositionChecker = new ObjectPositionChecker(mouseObjectController, this.playButtonObjectController);
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            if (ObjectPositionChecker.check()) {
                this.app.setScreen(new GameController(this.app, this.width, this.height));
            }
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

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
        this.app.playButton.dispose();
        this.app.background.dispose();

    }
}

package com.flappy.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.flappy.App;
import com.flappy.gameobjects.PipeCreator;
import com.flappy.utils.Collision;
import com.flappy.utils.Hud;
import com.flappy.utils.ObjectPositionChecker;

public class GameController implements Screen {


    public static final int GAME_SPEED = 2;
    private final App app;
    private final ObjectController backgroundController;
    private final ObjectController birdController;
    private final ObjectController groundController;
    private final float width;
    private final PipeCreator pipeCreator;
    private final ObjectPositionChecker objectPositionChecker;
    private final Collision collision;
    private final Hud hud;


    public GameController(App app, float width, float height) {
        this.app = app;
        this.width = width;
        this.backgroundController = new ObjectController(0, 0, width, height);
        this.birdController = new ObjectController(80, 500, this.app.bird.getWidth(), this.app.bird.getHeight());
        this.groundController = new ObjectController(0, 0, width, 200);
        this.pipeCreator = new PipeCreator(width / 2, 500, this.app.topPipe.getWidth(), this.app.topPipe.getHeight());
        this.objectPositionChecker = new ObjectPositionChecker(this.birdController, this.groundController);
        this.collision = new Collision(this.pipeCreator.getTopPipes(), this.pipeCreator.getBottomPipes(), this.birdController);
        this.hud = new Hud();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.app.batch.begin();

        this.app.batch.draw(this.app.background, this.backgroundController.getXPosition(), this.backgroundController.getYPosition(),
                this.backgroundController.getWidth(), this.backgroundController.getHeight());
        this.app.batch.draw(this.app.background, this.backgroundController.getXPosition() + this.width, this.backgroundController.getYPosition(),
                this.backgroundController.getWidth(), this.backgroundController.getHeight());

        this.app.batch.draw(this.app.bird, this.birdController.getXPosition(), this.birdController.getYPosition());

        for (int pipeIndex = 0; pipeIndex < pipeCreator.getTopPipes().size; pipeIndex++) {
            this.app.batch.draw(this.app.topPipe, this.pipeCreator.getTopPipes().get(pipeIndex).getX(), this.pipeCreator.getTopPipes().get(pipeIndex).getY());
            this.app.batch.draw(this.app.bottomPipe, this.pipeCreator.getBottomPipes().get(pipeIndex).getX(),
                    this.pipeCreator.getBottomPipes().get(pipeIndex).getY());
        }

        this.app.batch.draw(this.app.ground, this.groundController.getXPosition(), this.groundController.getYPosition(),
                this.groundController.getWidth(), this.groundController.getHeight());
        this.app.batch.draw(this.app.ground, this.groundController.getXPosition() + width,
                this.groundController.getYPosition(), this.groundController.getWidth(), this.groundController.getHeight());
        this.hud.getStage().draw();
        this.app.batch.end();

        this.backgroundController.move(-GAME_SPEED, 0);
        this.backgroundController.setXPosition(this.backgroundController.getXPosition() % App.WIDTH);
        this.groundController.move(-GAME_SPEED, 0);
        this.groundController.setXPosition(this.groundController.getXPosition() % this.app.ground.getWidth());
        this.birdController.gravity(-0.2f);

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            this.birdController.jump(5);
        }
        this.pipeCreator.move(-GAME_SPEED);
        this.pipeCreator.update(-this.app.topPipe.getWidth(), (float) (this.width * 1.5 - this.app.topPipe.getWidth()));
        if (this.objectPositionChecker.check() || this.collision.check()) {
            this.app.setScreen(new MenuController(this.app, width, backgroundController.getHeight()));
        }
        this.hud.updatePoints(this.pipeCreator.getTopPipes(), this.birdController);
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

    }
}

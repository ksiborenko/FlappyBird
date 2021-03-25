package com.flappy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flappy.controllers.MenuController;

public class App extends Game {

    public static final int HEIGHT = 800;
    public static final int WIDTH = 480;
    public SpriteBatch batch;
    public Texture background;
    public Texture playButton;
    public Texture bird;
    public Texture topPipe;
    public Texture bottomPipe;
    public Texture ground;
    public Texture gameOver;


    @Override
    public void create() {
        batch = new SpriteBatch();
        this.background = new Texture("background.png");
        this.playButton = new Texture("playbtn.png");
        this.bird = new Texture("bird.png");
        this.topPipe = new Texture("toptube.png");
        this.bottomPipe = new Texture("bottomtube.png");
        this.ground = new Texture("ground.png");
        this.gameOver = new Texture("gameOver.png");
        this.setScreen(new MenuController(this, WIDTH, HEIGHT));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        this.batch.dispose();
    }
}

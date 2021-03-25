package com.flappy.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.flappy.controllers.ObjectController;
import com.flappy.gameobjects.TopPipe;


public class Hud {

    public Stage stage;

    private final Label points;
    private final ScoreCount score;

    public Hud() {
        this.score = new ScoreCount();
        this.stage = new Stage();
        Label player = new Label("Score: ", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        this.points = new Label(String.format("%02d", this.score.getPoints()), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        table.add(player).padTop(10);
        table.add(points).padTop(10);
        this.stage.addActor(table);
    }

    public void updatePoints(Array<TopPipe> pipes, ObjectController controller) {
        this.score.count(pipes, controller);
        this.points.setText(this.score.getPoints());
    }

    public Stage getStage() {
        return stage;
    }
}
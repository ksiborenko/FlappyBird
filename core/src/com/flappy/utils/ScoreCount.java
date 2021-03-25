package com.flappy.utils;


import com.badlogic.gdx.utils.Array;
import com.flappy.controllers.ObjectController;
import com.flappy.gameobjects.TopPipe;

public class ScoreCount {


    private int points = 0;

    public void count(Array<TopPipe> pipes, ObjectController bird) {
        for (int pipeIndex = 0; pipeIndex < pipes.size; pipeIndex++) {
            if (bird.getXPosition() == pipes.get(pipeIndex).getX() + pipes.get(pipeIndex).getWidth()) {
                this.points++;
            }
        }
    }

    public int getPoints() {
        return points;
    }
}

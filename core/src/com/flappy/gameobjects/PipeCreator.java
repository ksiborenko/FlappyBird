package com.flappy.gameobjects;

import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class PipeCreator {

    public static final int PIPE_SPACING = 140;
    private final int pipesSize = 3;
    private final Array<TopPipe> topPipes;
    private final Array<BottomPipe> bottomPipes;

    public PipeCreator(float x, float y, float width, float height) {
        this.topPipes = new Array<>();
        this.bottomPipes = new Array<>();
        Random random = new Random();
        for (int pipeIndex = 0; pipeIndex < this.pipesSize; pipeIndex++) {

            float xPos = x + (x * pipeIndex);
            float yTop = y + random.nextInt(PIPE_SPACING);
            this.topPipes.add(new TopPipe(xPos, yTop, width, height));

            float yBottom = this.topPipes.get(pipeIndex).getY() - height - PIPE_SPACING;
            this.bottomPipes.add(new BottomPipe(xPos, yBottom, width, height));
        }
    }

    public void move(int xSpeed) {
        for (int pipeIndex = 0; pipeIndex < this.pipesSize; pipeIndex++) {
            this.topPipes.get(pipeIndex).move(xSpeed);
            this.bottomPipes.get(pipeIndex).move(xSpeed);
        }
    }

    public void update(float oldPosition, float newPosition) {
        for (int pipeIndex = 0; pipeIndex < this.pipesSize; pipeIndex++) {
            if (this.topPipes.get(pipeIndex).getX() < oldPosition) {
                this.topPipes.get(pipeIndex).setX(newPosition);
                this.bottomPipes.get(pipeIndex).setX(newPosition);
            }
        }
    }

    public Array<TopPipe> getTopPipes() {
        return topPipes;
    }

    public Array<BottomPipe> getBottomPipes() {
        return bottomPipes;
    }
}

package com.flappy.utils;

import com.badlogic.gdx.utils.Array;
import com.flappy.controllers.ObjectController;
import com.flappy.gameobjects.AbstractPipe;
import com.flappy.gameobjects.BottomPipe;
import com.flappy.gameobjects.TopPipe;

public class Collision {

    private final Array<TopPipe> topPipes;
    private final Array<BottomPipe> bottomPipes;
    private final ObjectController controller;

    public Collision(Array<TopPipe> topPipes, Array<BottomPipe> bottomPipes, ObjectController controller) {
        this.topPipes = topPipes;
        this.bottomPipes = bottomPipes;
        this.controller = controller;
    }

    public boolean check() {
        for (int pipeIndex = 0; pipeIndex < this.topPipes.size; pipeIndex++) {
            if (this.collision(this.topPipes.get(pipeIndex), this.controller) || this.collision(this.bottomPipes.get(pipeIndex), this.controller)) {
                return true;
            }
        }
        return false;
    }

    private boolean collision(AbstractPipe pipe, ObjectController controller) {
        return controller.getXPosition() + controller.getWidth() > pipe.getX() &&
                controller.getXPosition() < pipe.getX() + pipe.getWidth() &&
                controller.getYPosition() + controller.getHeight() > pipe.getY() &&
                controller.getYPosition() < pipe.getY() + pipe.getHeight();
    }
}

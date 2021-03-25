package com.flappy.gameobjects;

public abstract class AbstractPipe {

    private float x;
    private final float y;
    private final float width;
    private final float height;


    public AbstractPipe(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void move(int xSpeed) {
        this.x += xSpeed;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }
}



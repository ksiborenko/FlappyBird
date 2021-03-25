package com.flappy.controllers;

public class ObjectController {

    private float xPosition;
    private float yPosition;
    private final float width;
    private final float height;
    float yVelocity;
    float yAcceleration;

    public ObjectController(float xPosition, float yPosition, float width, float height) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.yVelocity = 0;
        this.yAcceleration = 0;
    }

    public void move(int xSpeed, int ySpeed) {
        this.xPosition += xSpeed;
        this.yPosition += ySpeed;
    }
    public void gravity(float ySpeed) {
        this.yAcceleration = ySpeed;
        this.yVelocity += this.yAcceleration;
        this.yPosition += this.yVelocity;
    }

    public void jump(float jump) {
        this.yVelocity = 0;
        this.yVelocity += jump;

    }

    public float getXPosition() {
        return xPosition;
    }

    public float getYPosition() {
        return yPosition;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void setXPosition(float xPosition) {
        this.xPosition = xPosition;
    }
}

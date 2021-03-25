package com.flappy.utils;

import com.flappy.controllers.ObjectController;

public class ObjectPositionChecker {

    ObjectController objectControllerOne;
    ObjectController objectControllerTwo;

    public ObjectPositionChecker(ObjectController objectControllerOne, ObjectController objectControllerTwo) {
        this.objectControllerOne = objectControllerOne;
        this.objectControllerTwo = objectControllerTwo;
    }

    public boolean check() {
        return objectControllerOne.getXPosition() < objectControllerTwo.getXPosition() + objectControllerTwo.getWidth() &&
                objectControllerOne.getXPosition() + objectControllerOne.getWidth() > objectControllerTwo.getXPosition() &&
                objectControllerOne.getYPosition() < objectControllerTwo.getYPosition() + objectControllerTwo.getHeight() &&
                objectControllerOne.getYPosition() + objectControllerOne.getHeight() > objectControllerTwo.getYPosition();
    }
}

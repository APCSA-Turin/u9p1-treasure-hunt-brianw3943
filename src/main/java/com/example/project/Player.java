package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        super(x, y);
        treasureCount = 0;
        numLives = 2;
    }


    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

  
    //move method should override parent class, sprite
    public void move(String direction) { //move the (x,y) coordinates of the player
        if (direction.equalsIgnoreCase("left")) {
            setX(getX() - 1);
        }
        if (direction.equalsIgnoreCase("right")) {
            setX(getX() + 1);
        }
        if (direction.equalsIgnoreCase("up")) {
            setY(getY() + 1);
        }
        if (direction.equalsIgnoreCase("down")) {
            setY(getY() - 1);
        }
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        if (direction.equalsIgnoreCase("a")) {
            return (getX() > 0);
        }
        if (direction.equalsIgnoreCase("d")) {
            return (getX() < size);
        }
        if (direction.equalsIgnoreCase("w")) {
            return (getY() < size);
        }
        if (direction.equalsIgnoreCase("s")) {
            return (getY() > 0);
        }
        return false;
    }


   
}




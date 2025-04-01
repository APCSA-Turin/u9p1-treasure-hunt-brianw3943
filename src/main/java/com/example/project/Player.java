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

    public String getCoords(){ //returns "Player:"+coordinates
        return "Player:" + super.getCoords();
    }


    public String getRowCol(int size){ //return "Player:"+row col
        return "Player:" + super.getRowCol(size);
    }

    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

  
    //move method should override parent class, sprite
    public void move(String direction) { //move the (x,y) coordinates of the player
        if (direction.equalsIgnoreCase("a")) {
            setX(getX() - 1);
        }
        if (direction.equalsIgnoreCase("d")) {
            setX(getX() + 1);
        }
        if (direction.equalsIgnoreCase("w")) {
            setY(getY() + 1);
        }
        if (direction.equalsIgnoreCase("s")) {
            setY(getY() - 1);
        }
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
        if (obj instanceof Enemy) {
            numLives--;
            if (numLives >= 0) {
                
            }
        } else if (obj instanceof Trophy) {
            if (numTreasures < 2) {

            } else {
                win = true;
            }
        } else if (obj instanceof Treasure) {
            numTreasures++;
            obj = new Dot(getX(), getY());
        }
        //numTreasures is the total treasures at the beginning of the game
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        if (direction.equalsIgnoreCase("a")) {
            return (getX() > 0);
        }
        if (direction.equalsIgnoreCase("d")) {
            return (getX() < size - 1);
        }
        if (direction.equalsIgnoreCase("w")) {
            return (getY() < size - 1);
        }
        if (direction.equalsIgnoreCase("s")) {
            return (getY() > 0);
        }
        return false;
    }


   
}




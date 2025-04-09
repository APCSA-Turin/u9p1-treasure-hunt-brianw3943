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
            setX(getX() - 1);   //if direction is right, decrease x value by 1
        }
        if (direction.equalsIgnoreCase("d")) {
            setX(getX() + 1);   //if direction is left, increase x value by 1
        }
        if (direction.equalsIgnoreCase("w")) {
            setY(getY() + 1);   //if direction is up, increase y value by 1
        }
        if (direction.equalsIgnoreCase("s")) {
            setY(getY() - 1);   //if direction is down, decrease y value by 1
        }
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
        if (obj instanceof Enemy) {     //checks if class of obj is Enemy, then removes a life if yes
            numLives--;
            if (numLives == 0) {
                
            }
        } else if (obj instanceof Trophy) {     //checks if class of obj is Trophy
            if (treasureCount < numTreasures) {     //checks if treasureCount is equal to or above required amount of treasures

            } else {
                win = true;     //if treasureCount is enough, win is set to true
            }
        } else if (obj instanceof Treasure) {       //checks if class of obj is Treasure, once it is determined to not be Trophy
            treasureCount++;                        //increases treasureCount if yes
            obj = new Dot(getX(), getY());          //replaces collected treasure with a Dot class
        }
        //numTreasures is the total treasures at the beginning of the game
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        if (direction.equalsIgnoreCase("a")) {
            return (getX() > 0);    //returns if x is in a valid position to move left (greater than 0)
        }
        if (direction.equalsIgnoreCase("d")) {
            return (getX() < size - 1);     //returns if x is in a valid position to move right (less than size - 1)
        }
        if (direction.equalsIgnoreCase("w")) {
            return (getY() < size - 1);     //returns if y is in a valid position to move up (less than size - 1)
        }
        if (direction.equalsIgnoreCase("s")) {
            return (getY() > 0);    //returns if y is in a valid position to move down (greater than 0)
        }
        return false;
    }


   
}




package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size = size;
        grid = new Sprite[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Dot(size - i, j);
            }
        }
    }

 
    public Sprite[][] getGrid(){return grid;}



    public void placeSprite(Sprite s){ //place sprite in new spot

    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction

    }


    public void display() { //print out the current grid to the screen 
        for (Sprite[] sprites : grid) {
            for (Sprite sprite : sprites) {
                System.out.print(sprite);
            }
            System.out.println();
        }
    }
    
    public void gameover(){ //use this method to display a loss
    }

    public void win(){ //use this method to display a win 
    }


}
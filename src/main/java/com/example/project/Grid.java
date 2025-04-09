package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size = size;
        grid = new Sprite[size][size];          //grid is initialized with size amount of sprites
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Dot(size - i, j);          //every sprite in grid is turned into Dot objects
            }
        }
    }

 
    public Sprite[][] getGrid(){return grid;}
    
    public Sprite getSpriteAt(int x, int y) {
        return grid[(size - 1 - y)][x];
    }


    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[(size - 1 - s.getY())][s.getX()] = s;
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        if (direction.equalsIgnoreCase("w")) {
            grid[(size - 1 - s.getY())][s.getX()] = s;
            grid[(size - s.getY())][s.getX()] = new Dot((size - 1 - s.getY()), s.getX());   //update sprite location to be one y level higher
        }
        if (direction.equalsIgnoreCase("a")) {
            grid[(size - 1 - s.getY())][s.getX()] = s;
            grid[(size - 1 - s.getY())][s.getX() + 1] = new Dot((size - 1 - s.getY()), s.getX());;   //update sprite location to be one x level lower
        }
        if (direction.equalsIgnoreCase("s")) {
            grid[(size - 1 - s.getY())][s.getX()] = s;
            grid[(size - 2 - s.getY())][s.getX()] = new Dot((size - 1 - s.getY()), s.getX());;   //update sprite location to be one y level lower
        }
        if (direction.equalsIgnoreCase("d")) {
            grid[(size - 1 - s.getY())][s.getX()] = s;
            grid[(size - 1 - s.getY())][s.getX() - 1] = new Dot((size - 1 - s.getY()), s.getX());;   //update sprite location to be one x level higher
        }
    }


    public void display() { //print out the current grid to the screen 
        for (Sprite[] sprites : grid) {
            for (Sprite sprite : sprites) {
                if (sprite instanceof Dot) {
                    System.out.print("⬜");          //prints all Dot sprites
                }
                if (sprite instanceof Player) {
                    System.out.print("🦄");         //prints Player sprite
                }
                if (sprite instanceof Enemy) {
                    System.out.print("🦂");         //prints all Enemy sprites
                }
                if (sprite instanceof Trophy) {
                    System.out.print("🏆");         //prints Trophy sprite
                } else if (sprite instanceof Treasure) {
                    System.out.print("🌈");         //prints all Treasure sprites
                }
            }
            System.out.println();
        }
    }
    
    public void gameover(){ //use this method to display a loss
        for (Sprite[] sprites : grid) {
            for (Sprite sprite : sprites) {
                if (sprite instanceof Sprite) {
                    System.out.print("💀");         //entire grid is displayed as a lose indicator
                }
            }
            System.out.println();
        }
        System.out.println("You Lose!");
    }

    public void win(){ //use this method to display a win 
        for (Sprite[] sprites : grid) {
            for (Sprite sprite : sprites) {
                if (sprite instanceof Sprite) {
                    System.out.print("🌈");         //entire grid is displayed as treasures
                }
            }
            System.out.println();
        }
        System.out.println("You Win!");
    }


}
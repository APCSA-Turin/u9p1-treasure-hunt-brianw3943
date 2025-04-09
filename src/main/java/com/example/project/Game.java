package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        initialize();
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);
        boolean win = false;
        boolean lose = false;

        while(win == false && lose == false){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop
            grid.display();
            System.out.println("Treasure count: " + player.getTreasureCount());
            System.out.println("Lives: " + player.getLives());
            String input = scanner.nextLine();
            if (player.isValid(size, input)) {
                if (input.equalsIgnoreCase("w")) {
                    player.interact(size, input, 2, grid.getSpriteAt(player.getX(), player.getY() + 1));        //interacts with the object directly in front of the player (up)
                } else if (input.equalsIgnoreCase("a")) {
                    player.interact(size, input, 2, grid.getSpriteAt(player.getX() - 1, player.getY()));        //interacts with the object directly in front of the player (right)
                } else if (input.equalsIgnoreCase("s")) {
                    player.interact(size, input, 2, grid.getSpriteAt(player.getX(), player.getY() - 1));        //interacts with the object directly in front of the player (down)
                } else if (input.equalsIgnoreCase("d")) {
                    player.interact(size, input, 2, grid.getSpriteAt(player.getX() + 1, player.getY()));        //interacts with the object directly in front of the player (left)
                }
                player.move(input);     //moves player based on entered direction
                grid.placeSprite(player, input);    //places player on grid based on entered direction
                if (player.getLives() <= 0) {       //lose condition
                    clearScreen();
                    grid.gameover();        //display lose screen
                    lose = true;
                    scanner.close();
                    return;         //end program
                }
                if (player.getWin()) {      //win condition
                    clearScreen();
                    grid.win();     //display win screen
                    win = true;
                    scanner.close();
                    return;     //end program
                }
            } else {
            }
        }
        scanner.close();
    }

    public void initialize(){
        size = 10;                          //initialize grid size
        grid = new Grid(size);
        player = new Player(0, 0);      //initializes all sprites to a coordinate
        enemies = new Enemy[2];
        enemies[0] = new Enemy(4, 4);
        enemies[1] = new Enemy(8, 8);
        treasures = new Treasure[2];
        treasures[0] = new Treasure(5, 8);
        treasures[1] = new Treasure(7, 5);
        trophy = new Trophy(0, size - 1);
        grid.placeSprite(player);           //place all sprites on grid
        grid.placeSprite(enemies[0]);
        grid.placeSprite(enemies[1]);
        grid.placeSprite(treasures[0]);
        grid.placeSprite(treasures[1]);
        grid.placeSprite(trophy);
        
        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
    }

    public static void main(String[] args) {
        Game game = new Game(10);
    }
}
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


        while(true){
            try {
                Thread.sleep(1000); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop
            grid.display();
            System.out.println("Treasure count: " + player.getTreasureCount());
            System.out.println("Lives: " + player.getLives());
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if (player.isValid(size, input)) {
                player.interact(size, input, 2, treasures[0]);
                player.move(input);
                grid.placeSprite(player, input);
                if (player.getLives() <= 0) {
                    clearScreen();
                    grid.gameover();
                    scan.close();
                    return;
                }
                if (player.getTreasureCount() == 2) {
                    clearScreen();
                    grid.win();
                    scan.close();
                    return;
                }
            } else {
                System.out.println("Out of bounds");
            }
        }
    }

    public void initialize(){
        size = 10;
        grid = new Grid(size);
        player = new Player(0, 0);
        enemies = new Enemy[2];
        enemies[0] = new Enemy(4, 4);
        enemies[1] = new Enemy(8, 8);
        treasures = new Treasure[2];
        treasures[0] = new Treasure(5, 8);
        treasures[1] = new Treasure(7, 5);
        trophy = new Trophy(0, size - 1);
        grid.placeSprite(player);
        grid.placeSprite(enemies[0]);
        grid.placeSprite(enemies[1]);
        grid.placeSprite(treasures[0]);
        grid.placeSprite(treasures[1]);
        grid.placeSprite(trophy);
        
        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
    }

    public static void main(String[] args) {
        Game game = new Game(10);
        game.play();
    }
}
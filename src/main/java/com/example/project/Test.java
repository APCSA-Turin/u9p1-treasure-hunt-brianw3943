package com.example.project;

import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
        Grid grid = new Grid(10);
        Player player = new Player(0, 0);
        Enemy enemy1 = new Enemy(5, 5);
        Enemy enemy2 = new Enemy(8, 5);
        grid.placeSprite(player);
        grid.placeSprite(enemy1);
        grid.placeSprite(enemy2);
        grid.display();
        while(1 != 0) {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if (player.isValid(10, input)) {
                player.interact(10, input, player.getTreasureCount(), enemy1.getClass());
                player.move(input);
                grid.placeSprite(player, input);
                grid.display();
                if (player.getLives() <= 0) {
                    grid.gameover();
                }
                if (player.getTreasureCount() == 2) {
                    grid.win();
                }
                System.out.println("Treasure count: " + player.getTreasureCount());
                System.out.println("Lives: " + player.getLives());
            } else {
                System.out.println("Out of bounds");
            }
        }
    }
}
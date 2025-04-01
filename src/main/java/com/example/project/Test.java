package com.example.project;

import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
        Grid grid = new Grid(10);
        Player player = new Player(0, 0);
        grid.placeSprite(player);
        grid.display();
        System.out.println();
        while(1 != 0) {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if (player.isValid(10, input)) {
                player.move(input);
                grid.placeSprite(player, input);
                grid.display();
            } else {
                System.out.println("Out of bounds");
            }
        }
    }
}
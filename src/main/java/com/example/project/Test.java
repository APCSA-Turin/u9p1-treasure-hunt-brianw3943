package com.example.project;
public class Test {
    public static void main(String args[]) {
        Grid grid = new Grid(10);
        Player player = new Player(0, 0);
        grid.placeSprite(player);
        grid.display();
        System.out.println();
        player.move("w");
        grid.placeSprite(player, "w");
        grid.display();
        System.out.println();
        player.move("d"); //move right
        grid.placeSprite(player, "d");
        grid.display();
    }
}
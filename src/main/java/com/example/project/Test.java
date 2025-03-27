package com.example.project;
public class Test {
    public static void main(String args[]) {
        Grid grid = new Grid(10);
        Player player = new Player(0, 0);
        grid.display();
        System.out.println();
        player.move("w");
        grid.display();
    }
}
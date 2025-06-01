package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleshipGame {
    public static void main(String[] args) {
        // Create the battleship object
        Battleship ship = new Battleship();

        List<String> shipLoaction = new ArrayList<>();

        shipLoaction.add("A2");
        shipLoaction.add("A3");
        shipLoaction.add("A4");

        ship.setLocation(shipLoaction);

        boolean isAlive = true; // This detemrines if the ship is still alive and the game should continue running.
        int numOfGuesses = 0;
        while(isAlive) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Guess the location of the ship: ");
            String userGuess = scanner.nextLine();

            String result = ship.checkHit(userGuess);

            if(result.equals("kill")) {
                numOfGuesses++;
                System.out.println("You sunk the ship! It took you " + numOfGuesses + " tries!");

                isAlive = false;
            }else if(result.equals("hit")) {
                numOfGuesses++;
                System.out.println("You hit the ship!");
            }else if(result.equals("miss")) {
                numOfGuesses++;
                System.out.println("Miss! Try Again!");
            }
        }
    }
}

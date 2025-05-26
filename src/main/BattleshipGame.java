package main;

import java.util.Scanner;

public class BattleshipGame {
    public static void main(String[] args) {
        Battleship ship = new Battleship();
        // @TODO Implement RNG into the game so the location of the ship is dynamic each time we start the game
        ship.setLocation("A2");
        ship.setLocation("A3");
        ship.setLocation("A4");

        boolean isAlive = true; // This detemrines if the ship is still alive and the game should continue running.
        int numOfGuesses = 0;
        while(isAlive) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Make a guess: ");
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

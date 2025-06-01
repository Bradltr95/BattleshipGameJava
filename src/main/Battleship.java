package main;

import java.util.ArrayList;
import java.util.List;

public class Battleship {
    private List<String> locationCells = new ArrayList<>();
    private int numOfHits = 0;

    /***
     * Set the instance variable locationCells of the Battleship with the local
     * variable passed into the setLocation function.
     * @param loc The starting position on the battleship grid.
     */
    public void setLocation(List<String> loc) {
        locationCells = loc;
    }

    /***
     * Take a value userGuess and check if the value matches one of the location cells of the ship.
     * If the user guesses one of the location cells of the ship we inrement the number of hits and return a "hit"
     * @param userGuess - A string value for a cell location such as A3, B4, etc.
     * @return returns either a - hit, miss, or kill depeneding on the user
     * guess.
     */
    public String checkHit(String userGuess) {
        String hitStatus = "miss";

        int index = locationCells.indexOf(userGuess);

        if(index >= 0) { // If the number is greater than 0 we know its a hit
            locationCells.remove(index);
            numOfHits++;

            if(locationCells.isEmpty()) {
                hitStatus = "kill";
            } else {
                hitStatus = "hit";
            }
        }

        return hitStatus;
    }
}
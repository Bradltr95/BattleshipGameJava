package main;

import java.util.ArrayList;

public class Battleship {
    private ArrayList<Integer> locationCells = new ArrayList<>();
    private int numOfHits = 0;

    /***
     * This function will set the 3 cell locations of the battlship based on the initial
     * baseNumber that gets passed into the function. ex: if baseNumber of 5 is passed, then
     * the function will set the battleships location to 5, 6, 7. This assumes the array has a size
     * of 3. The function is able to increment from the base number for however many cells exist in the
     * locationCells array of the battleship.
     * @param baseNumber The starting position on the battleship grid.
     */
    public void setLocation(int baseNumber) {
        for(int i = 0; i < locationCells.size(); i++) {
            locationCells.add(baseNumber);
        }
    }

    /***
     * Take a userGuesss and check if the guess matches a cell location of
     * the battleship. If it matches the location we return a hit, otherwise we return a miss.
     * If we hit all 3 cells, than we know we killed the ship, and we can return "kill".
     * @param userGuess The user guess to comapre to each location of the battleship cells
     * @return returns either a - hit, miss, or kill depeneding on the user
     * guess.
     */
    public String checkHit(int userGuess) {
        String hitStatus = "miss";

        for(int i = 0; i < locationCells.size(); i++) {
            if(locationCells.contains(userGuess)) { // hit
                locationCells.set(i, -1); // Lets us know the cell has been hit before
                numOfHits++; // Increments the number of hits
                hitStatus = "hit";
                break;
            }

            if(locationCells.contains(-1)) {
                hitStatus = "miss"; // we've hit this before
            }
        }

        if(numOfHits == locationCells.size()) { hitStatus = "kill"; }

        return hitStatus;
    }
}
package main;

import java.util.ArrayList;

public class Battleship {
    private ArrayList<String> locationCells = new ArrayList<>();
    private int numOfHits = 0;

    /***
     * This function will set the 3 cell locations of the battlship based on the initial
     * baseNumber that gets passed into the function. ex: if baseNumber of 5 is passed, then
     * the function will set the battleships location to 5, 6, 7. This assumes the array has a size
     * of 3. The function is able to increment from the base number for however many cells exist in the
     * locationCells array of the battleship.
     * @param baseLocation The starting position on the battleship grid.
     */
    public void setLocation(String baseLocation) {
        for(int i = 0; i < locationCells.size(); i++) {
            locationCells.add(baseLocation);
        }
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

        for(String location : locationCells) {
            // This will return -1 if the index doesnt exist
            int index = locationCells.indexOf(userGuess);

            if(index >= 0) { // If the number is greater than 0 we know its a hit
                numOfHits++;
                hitStatus = "hit";
                locationCells.remove(index);
                break;
            }
        }

        return hitStatus;
    }
}
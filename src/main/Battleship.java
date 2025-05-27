package main;

import java.util.ArrayList;

public class Battleship {
    private ArrayList<String> locationCells = new ArrayList<>();
    private int numOfHits = 0;

    /***
     * The purpose of this fucntion is to set the location of the ships 3 cells automatically for us based
     * on the initial baseLocation paramater that we provide. For example, if we provide a base of A4 then
     * the function will extract the A and 4, increment the number portion and add the other two cells to the location
     * array list.
     * @param baseLocation The starting position on the battleship grid.
     */
    public void setLocation(String baseLocation) {
        char row = baseLocation.charAt(0); // Get the row A,B,C,D
        int column = Integer.parseInt(baseLocation.substring(1));

        for(int i = 0; i < 3; i++) {
            locationCells.add(row + String.valueOf(column + i));
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

        int index = locationCells.indexOf(userGuess);

        if(index >= 0) { // If the number is greater than 0 we know its a hit
            locationCells.remove(index);
            numOfHits++;

            if(locationCells.isEmpty()) {
                hitStatus = "kill";
            }else {
                hitStatus = "hit";
            }
        }

        return hitStatus;
    }
}
package test;

import main.Battleship;
import java.util.logging.Logger;

class BattleshipTest {
    // Use the logger to report test results instead of using Systems print function.
    private static final Logger logger = Logger.getLogger(BattleshipTest.class.getName());
    private static final String FAILED = "failed";
    private static String PASSED = "passed";

    public static void main(String[] args) {
        logger.info("Test Case 1: " + checkMissTest());
        logger.info("Test Case 2: " + checkHitTest());
        logger.info("Test Case 3: " + checkKillTest());
        logger.info("Test Case 4: " + checkHitThenMiss());
        logger.info("Test Case 5: " + hitSameLocationTwice());
    }

    /**
     * Create a ship, set its location and verify that the correct string is returned when
     * we successfully guess and hit one of the ship's locations.
     * @return testResult - The given test result as a String. Either "passed" or "failed"
     * @date 05/19/25
     */
    public static String checkHitTest() {
        Battleship ship = new Battleship();
        ship.setLocation("A4");
        ship.setLocation("A5");
        ship.setLocation("A6");
        String hitResult = ship.checkHit("A4");

        String testResult = FAILED;
        if(hitResult.equals("hit")) {
            testResult = PASSED;
        }
        return testResult;
    }

    /**
     * Create a ship, set its location and verify that the correct string is returned when
     * we successfully guess and hit all of the ship's locations sinking/"killing" the ship.
     * @return testResult - The given test result as a String. Either "passed" or "failed"
     * @date 05/19/25
     */
    public static String checkKillTest() {
        Battleship ship = new Battleship();
        ship.setLocation("A4"); // Will set the location cells to 4, 5, 6
        String hitResult = ship.checkHit("A4");
        String testResult = FAILED;
        if(hitResult.equals("kill")) {
            testResult = PASSED;
        }
        return testResult;
    }

    /**
     * Create a ship, set its location and verify that the corrcet string is returned when we miss a ship.
     * @return testResult - The given test result as a String. Either "passed" or "failed".
     * @author Bradley Latreille
     * @date 05/19/25
     */
    public static String checkMissTest() {
        Battleship ship = new Battleship();
        ship.setLocation("A4"); // Will set the location cells to 4, 5, 6
        String hitResult = ship.checkHit("A3");

        String testResult = FAILED;
        if(hitResult.equals("miss")) {
            testResult = PASSED;
        }
        return testResult;
    }

    /**
     * Create a battleship, set its location and hit the ship followed by a miss. The test
     * checks that the hit result and the miss result return the expected string value.
     * @return testResult - The given test result as a String. Either "passed" or "failed".
     * @author Bradley Latreille
     * @date 05/19/25
     */
    public static String checkHitThenMiss() {
        Battleship ship = new Battleship();
        ship.setLocation("A4"); // Will set the location cells to 4, 5, 6
        ship.setLocation("A5"); // Will set the location cells to 4, 5, 6
        ship.setLocation("A6"); // Will set the location cells to 4, 5, 6
        String hitResult = ship.checkHit("A4");
        String missResult = ship.checkHit("A3");

        String testResult = FAILED;
        if(missResult.equals("miss") && hitResult.equals("hit")) {
            testResult = PASSED;
        }
        return testResult;
    }

    /***
     * Test to ensure that we don't get a hit back if we keep trying to hit the same spot.
     * @return testResult - The result of the test is returned as a String
     * @author Bradley Latreille
     * @date 05/19/25
     */
    public static String hitSameLocationTwice() {
        Battleship ship = new Battleship();
        ship.setLocation("A4"); // Will set the location cells to 4, 5, 6
        ship.setLocation("A5"); // Will set the location cells to 4, 5, 6
        ship.setLocation("A6"); // Will set the location cells to 4, 5, 6
        String hitResult = ship.checkHit("A4");
        String missResult = ship.checkHit("A4");

        String testResult = FAILED;
        if(missResult.equals("miss") && hitResult.equals("hit")) {
            testResult = PASSED;
        }
        return testResult;
    }
}
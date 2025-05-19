package test;

import main.Battleship;

class BattleshipTest {
    public static void main(String[] args) {
        System.out.println("Test Case 1: " + checkMissTest());
        System.out.println("Test Case 2: " + checkHitTest());
        System.out.println("Test Case 3: " + checkKillTest());
        System.out.println("Test Case 4: " + checkHitThenMiss());
        System.out.println("Test Case 5: " + hitSameLocationTwice());
    }

    // Complete writing this test case
    public static String checkHitTest() {
        Battleship ship = new Battleship();
        ship.setLocation(4); // Will set the location cells to 4, 5, 6
        String hitResult = ship.checkHit(4);

        String testResult = "failed";
        if(hitResult.equals("hit")) {
            testResult = "passed";
        }
        return testResult;
    }

    // Complete writing this test case
    public static String checkKillTest() {
        Battleship ship = new Battleship();
        ship.setLocation(4); // Will set the location cells to 4, 5, 6
        ship.checkHit(4);
        ship.checkHit(5);
        // We only need to capture the last hit to see if we get a "kill"
        String hitResult = ship.checkHit(6);
        String testResult = "failed";
        if(hitResult.equals("kill")) {
            testResult = "passed";
        }
        return testResult;
    }

    public static String checkMissTest() {
        Battleship ship = new Battleship();
        ship.setLocation(4); // Will set the location cells to 4, 5, 6
        String hitResult = ship.checkHit(3);

        String testResult = "failed";
        if(hitResult.equals("miss")) {
            testResult = "passed";
        }
        return testResult;
    }

    public static String checkHitThenMiss() {
        Battleship ship = new Battleship();
        ship.setLocation(4); // Will set the location cells to 4, 5, 6
        String hitResult = ship.checkHit(4);
        String missResult = ship.checkHit(3);

        String testResult = "failed";
        if(missResult.equals("miss") && hitResult.equals("hit")) {
            testResult = "passed";
        }
        return testResult;
    }

    /***
     * Test to ensure that we don't get a hit back if we keep trying to hit the same spot.
     * @return testResult - The result of the test is returned as a String
     */
    public static String hitSameLocationTwice() {
        Battleship ship = new Battleship();
        ship.setLocation(4); // Will set the location cells to 4, 5, 6
        String hitResult = ship.checkHit(4);
        String missResult = ship.checkHit(4);
        System.out.println(missResult);

        String testResult = "failed";
        if(missResult.equals("miss") && hitResult.equals("hit")) {
            testResult = "passed";
        }
        return testResult;
    }
}
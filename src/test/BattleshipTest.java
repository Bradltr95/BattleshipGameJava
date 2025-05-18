package test;

import main.Battleship;

class BattleshipTest {
    public static void main(String[] args) {
        System.out.println("Test Case 1: " + checkMissTest());
    }

    // Complete writing this test case
    public static void checkHitTest() {

    }

    // Complete writing this test case
    public static void checkKillTest() {

    }

    public static String checkMissTest() {
        Battleship ship = new Battleship();
        ship.setLocation(4); // Will set the location cells to 4, 5, 6
        String hitResult = ship.checkHit(3); // Since 3 is not part of the location cells this should return "miss"

        String testResult = "failed";
        if(hitResult.equals("miss")) {
            testResult = "passed";
        }
        return testResult;
    }
}
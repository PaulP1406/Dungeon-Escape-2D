package main;

import java.awt.Rectangle;

/**
 * The EventChecker class is responsible for checking events and interactions in
 * the game.
 */
public class EventChecker {
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    /**
     * Constructs an EventChecker object.
     * 
     * @param gp The GamePanel instance.
     */
    public EventChecker(GamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 1;
        eventRect.height = 1;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    /**
     * Checks for events and triggers corresponding actions.
     */
    public void checkEvent() {        
        checkLavaPits();
        checkWaterPits();
        checkExitTile();
    }

    /**
     * Contains the coordinate and the logic for checking if the player is on a lava
     * tile
     */
    private void checkLavaPits() {
        int[][] lavaPits = {
                { 16, 21 }, { 17, 21 }, { 18, 21 }, { 19, 21 }, { 20, 21 }, { 21, 21 }, { 22, 21 }, { 23, 21 },
                { 24, 21 }, { 25, 21 }, { 26, 21 }, { 27, 21 }, { 28, 21 }, { 29, 21 }, { 30, 21 },
                { 16, 22 }, { 17, 22 }, { 18, 22 }, { 19, 22 }, { 20, 22 }, { 21, 22 }, { 22, 22 }, { 23, 22 },
                { 24, 22 }, { 25, 22 }, { 26, 22 }, { 27, 22 }, { 28, 22 }, { 29, 22 }, { 30, 22 },
                { 16, 23 }, { 17, 23 }, { 16, 24 }, { 17, 24 }, { 16, 29 }, { 17, 29 }, { 17, 30 }, { 16, 30 },
                { 16, 31 }, { 17, 31 }, { 16, 32 }, { 17, 32 },
                { 29, 23 }, { 30, 23 }, { 29, 24 }, { 30, 24 }, { 29, 25 }, { 30, 25 }, { 29, 26 }, { 30, 26 },
                { 29, 27 }, { 30, 27 }, { 29, 28 }, { 30, 28 }, { 29, 29 }, { 30, 29 }, { 29, 30 }, { 30, 30 },
                { 29, 31 }, { 30, 31 }, { 29, 32 }, { 30, 32 },
                { 18, 31 }, { 19, 31 }, { 20, 31 }, { 21, 31 }, { 22, 31 }, { 23, 31 }, { 24, 31 }, { 25, 31 },
                { 26, 31 }, { 27, 31 }, { 28, 31 }, { 18, 32 }, { 19, 32 }, { 20, 32 }, { 21, 32 }, { 22, 32 },
                { 23, 32 }, { 24, 32 }, { 25, 32 }, { 26, 32 }, { 27, 32 }, { 28, 32 }
        };
        for (int[] tile : lavaPits) {
            if (touch(tile[1], tile[0], "right")) {
                lavaPit();
            }
        }
    }

    /**
     * Contains the coordinate and the logic for checking if the player is on a
     * water tile
     */
    private void checkWaterPits() {
        int[][] waterPits = {
                { 7, 18 }, { 8, 18 }, { 9, 18 },
                { 7, 19 }, { 8, 19 }, { 9, 19 },
                { 7, 34 }, { 8, 34 }, { 9, 34 },
                { 7, 35 }, { 8, 35 }, { 9, 35 },
                { 27, 7 }, { 28, 7 }, { 29, 7 }, { 30, 7 }, { 31, 7 },
                { 27, 8 }, { 28, 8 }, { 29, 8 }, { 30, 8 }, { 31, 8 },
                { 27, 45 }, { 28, 45 }, { 29, 45 }, { 30, 45 }, { 31, 45 },
                { 27, 46 }, { 28, 46 }, { 29, 46 }, { 30, 46 }, { 31, 46 }
        };
        for (int[] tile : waterPits) {
            if (touch(tile[1], tile[0], "right")) {
                waterPit();
            }
        }
    }

    /**
     * Contains the coordinate and the logic for checking if the player is on an
     * exit tile
     */
    private void checkExitTile() {
        int[][] exitTiles = {
                { 25, 1 }, { 26, 1 }, { 27, 1 }
        };
        for (int[] tile : exitTiles) {
            if (touch(tile[0], tile[1], "right") && gp.prisoner.chestCount == 8 && gp.prisoner.skullCount == 4) {
                exitTile();
            }
        }
    }

    /**
     * Checks if the player character touches a specific location.
     * 
     * @param eventCol     The column of the event location.
     * @param eventRow     The row of the event location.
     * @param keyDirection The direction key pressed by the player.
     * @return A boolean indicating whether the event is triggered.
     */

    public boolean touch(int eventCol, int eventRow, String keyDirection) {
        boolean touch = false;
        gp.prisoner.recArea.x = gp.prisoner.mapX + gp.prisoner.recArea.x;
        gp.prisoner.recArea.y = gp.prisoner.mapY + gp.prisoner.recArea.y;
        eventRect.x = eventCol * gp.tileSize + eventRect.x;
        eventRect.y = eventRow * gp.tileSize + eventRect.y;

        if (gp.prisoner.recArea.intersects(eventRect)) {
            if (gp.prisoner.direction.contentEquals(keyDirection) || keyDirection.contentEquals("any")) {
                touch = true;
            }
            touch = true;
        }

        gp.prisoner.recArea.x = gp.prisoner.recAreaDefaultX;
        gp.prisoner.recArea.y = gp.prisoner.recAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return touch;
    }

    /**
     * Triggers the action for stepping into a lava pit.
     */
    public void lavaPit() {
        gp.prisoner.hp -= 1;
    }

    /**
     * Triggers the action for stepping into a water pit.
     */
    public void waterPit() {
        if (gp.prisoner.hp <= 4) {
            gp.prisoner.hp += 1;
        }

    }

    /**
     * Triggers the action for reaching the exit tile.
     */
    public void exitTile() {
        gp.gameState = gp.gameFinished;
    }
}

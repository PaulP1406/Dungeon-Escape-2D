package game.Dungeon.tileTest;

import org.junit.jupiter.api.Test;

import tile.Tile;

import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void testTileInitialState() {
        Tile tile = new Tile();
        assertNull(tile.image, "Tile image should initially be null");
        assertFalse(tile.collision, "Tile collision should initially be false");
    }

}

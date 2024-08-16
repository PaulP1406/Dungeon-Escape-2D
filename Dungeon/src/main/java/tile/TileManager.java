package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;

/**
 * TileManager handles the loading, management, and rendering of tiles in the
 * map.
 * It reads tile definitions from a file and draws them on the game panel.
 */
public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;
    boolean drawPath = true;

    /**
     * Constructs a TileManager object
     *
     * @param gp The main gamepanel of the game
     */
    public TileManager(GamePanel gp) {
        this.gp = gp;

        this.tile = new Tile[10];
        gp.getClass();
        gp.getClass();
        this.mapTileNum = new int[54][43];

        getTileImage();
        loadMap("/maps/world01.txt");
    }

    /**
     * Loads tile images and sets their collision properties.
     */
    public void getTileImage() {

        tileImagesSetUp(0, "Wall", true);
        tileImagesSetUp(1, "Stone", false);
        tileImagesSetUp(2, "Water", false);
        tileImagesSetUp(3, "Lava", false);
        tileImagesSetUp(4, "gold", false);
    }

    /**
     * Helper method to load a tile image and set its collision property.
     *
     * @param index     The index of the tile in the tile array.
     * @param imageName The name of the image file for the tile.
     * @param collision Whether the tile should be considered as having collision.
     */
    public void tileImagesSetUp(int index, String imageName, boolean collision) {
        UtilityTool uTool = new UtilityTool();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the map from a text file, parsing it into the mapTileNum array.
     *
     * @param filePath The path to the map file.
     */
    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            this.gp.getClass();
            this.gp.getClass();
            while (col < 54 && row < 43) {

                String line = br.readLine();

                this.gp.getClass();
                while (col < 54) {

                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    this.mapTileNum[col][row] = num;
                    col++;
                }
                this.gp.getClass();
                if (col == 54) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception exception) {
        }
    }

    /**
     * Renders the tiles on the game panel based on the map configuration.
     *
     * @param g2 The Graphics2D object for drawing the tiles.
     */
    public void create(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        this.gp.getClass();
        this.gp.getClass();
        while (worldCol < 54 && worldRow < 43) {

            int tileNum = this.mapTileNum[worldCol][worldRow];
            
            int worldX = worldCol * 48;
            
            int worldY = worldRow * 48;
            int screenX = worldX - this.gp.prisoner.mapX + this.gp.prisoner.monitorX;
            int screenY = worldY - this.gp.prisoner.mapY + this.gp.prisoner.monitorY;

           
            if (worldX + 48 > this.gp.prisoner.mapX - this.gp.prisoner.monitorX
                    && worldX - 48 < this.gp.prisoner.mapX + this.gp.prisoner.monitorX
                    && worldY + 48 > this.gp.prisoner.mapY - this.gp.prisoner.monitorY
                    && worldY - 48 < this.gp.prisoner.mapY + this.gp.prisoner.monitorY) {

                this.gp.getClass();
                this.gp.getClass();
                g2.drawImage((this.tile[tileNum]).image, screenX, screenY, null);
            }

            worldCol++;

            this.gp.getClass();
            if (worldCol == 54) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}

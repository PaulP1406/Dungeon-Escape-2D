package game.Dungeon.mainTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import main.GamePanel;
import main.UI;

class UITest {


    @Test
    public void testUIConstructorInitialization() {
        // Verify GamePanel is correctly set
    	GamePanel gpMock = mock(GamePanel.class);
        UI ui = new UI(gpMock);
        // Verify font weights are initialized correctly
        assertEquals(new Font("Calibri", 0, 40), ui.getFontWeight40());
        assertEquals(new Font("Calibri", 1, 80), ui.getFontWeight80B());

        // Verify images are initialized correctly
        assertNotNull(ui.getChestImage());
        assertNotNull(ui.getSkullImage());
        assertNotNull(ui.getHeart_empty());
        assertNotNull(ui.getHeart_half());
        assertNotNull(ui.getHeart_full());
    }
    
    @Test
    void testDraw() {
    	GamePanel gpMock = new GamePanel();
        Graphics2D g2Mock = mock(Graphics2D.class);
        UI ui = new UI(gpMock);
        gpMock.gameState = gpMock.playState;
    	ui.draw(g2Mock);
        // Verify that the necessary drawing methods are called with the expected parameters
        verify(g2Mock).setFont(ui.getFontWeight40());
        verify(g2Mock).setColor(Color.white);
        verify(g2Mock).drawString("Score: " + gpMock.prisoner.score, 550, 50);
        verify(g2Mock).drawImage(ui.getChestImage(), 600, 60, gpMock.tileSize, gpMock.tileSize, null);
        verify(g2Mock).drawString("x " + gpMock.prisoner.chestCount, 660, 100);
        verify(g2Mock).drawImage(ui.getSkullImage(), 600, 110, gpMock.tileSize, gpMock.tileSize, null);
        verify(g2Mock).drawString("x " + gpMock.prisoner.skullCount, 660, 150);
        verify(g2Mock).drawString("Time: " + ui.getdF().format(0) + "s", 275, 50);
        assert(ui.playTime == (double)1/60);
        int x = gpMock.tileSize / 2;
        int y = gpMock.tileSize / 2;
        int i = 0;
        while (i < gpMock.prisoner.maxHP / 2) {
        	verify(g2Mock).drawImage(ui.getHeart_empty(), x, y, null);
            x += gpMock.tileSize;
            i++;
        }
        x = gpMock.tileSize / 2;
        y = gpMock.tileSize / 2;
        i = 0;
        while (i < gpMock.prisoner.hp) {
        	verify(g2Mock).drawImage(ui.getHeart_half(), x, y, null);
            i++;
            if (i < gpMock.prisoner.hp) {
            	verify(g2Mock).drawImage(ui.getHeart_full(), x, y, null);
            }
            i++;
            x += gpMock.tileSize;
        }
        when(g2Mock.getFont()).thenReturn(ui.getFontWeight40());
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        FontMetrics fontMetrics = g2d.getFontMetrics();
    	//Check if gameover state is called
    	gpMock.gameState = gpMock.gameOver;
    	ui.draw(g2d);
    	assertEquals(g2d.getColor(), Color.white);
    	assertEquals(g2d.getFont(),(g2d.getFont().deriveFont(50f)));
    	//Check if pause state is called
        gpMock.gameState = gpMock.pauseState;
    	ui.draw(g2d);
    	assertEquals(g2d.getFont(),(g2d.getFont().deriveFont(Font.PLAIN, 80)));
    	//Check if game finished state is called
    	gpMock.gameState = gpMock.gameFinished;
    	ui.draw(g2d);
    	assertEquals(g2d.getColor(), Color.white);
    	assertEquals(g2d.getFont(),(g2d.getFont().deriveFont(50f)));
    }
  
}


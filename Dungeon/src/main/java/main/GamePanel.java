package main;

import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import character.Character;
import character.Prisoner;
import enemyAi.EnemyAI;
import object.Object;
import object.Boots;
import object.Heart;
import tile.TileManager;

/**
 * The GamePanel class represents the main panel of the game.
 * It is responsible for rendering and updating all game elements, including the
 * player, enemies, objects,
 * tiles, and user interface components. This panel manages the game's state,
 * controls the game loop, and
 * handles user input. Additionally, it provides methods for setting up the
 * game, retrying after a game over,
 * updating the game state, and starting the game thread.
 */
public class GamePanel extends JPanel implements Runnable {
  final int originalTileSize = 16;
  final int scale = 3;
  public final int tileSize = 48;
  public final int maxScreenCol = 16;
  public final int maxScreenRow = 12;
  public final int screenWidth = 768;
  public final int screenHeight = 576;
  public final int maxWorldCol = 54;
  public final int maxWorldRow = 43;
  
  int screenWidthFull=screenWidth;
  int screenHeightFull=screenHeight;
  BufferedImage tempScreen;
  Graphics2D g2;
  
  int FPS = 60;
  public TileManager tileM = new TileManager(this);
  KeyChecker keyH = new KeyChecker(this);

  public CollisionChecker cChecker = new CollisionChecker(this);
  public AssetSetter aSetter = new AssetSetter(this);
  public Prisoner prisoner = new Prisoner(this, this.keyH);
  public Object[] obj = new Object[20];
  public Character[] enemy = new Character[10];
  public UI ui = new UI(this);
  public EventChecker eHandler = new EventChecker(this);
  public EnemyAI pFinder = new EnemyAI(this);
  Thread gameThread;
  public long currentTime = 0;

  // GAME STATE
  public int gameState;
  public final int playState = 1;
  public final int pauseState = 2;
  public final int gameOver = 3;
  public final int gameFinished = 4;

  /**
   * Constructs a GamePanel object.
   */
  public GamePanel() {
    setPreferredSize(new Dimension(768, 576));
    setBackground(Color.black);
    setDoubleBuffered(true);
    addKeyListener(this.keyH);
    setFocusable(true);
  }

  /**
   * Sets up the game.
   */
  public void setupGame() {
    this.aSetter.setEnemy();
    this.aSetter.setObject();
    gameState = playState;
  
   /* tempScreen=new BufferedImage(screenWidth,screenHeight,BufferedImage.TYPE_INT_ARGB);
    g2=(Graphics2D)tempScreen.getGraphics();
    //setFullScreen();
     * 
     */
  }
  /*
  public void setFullScreen() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		Main.window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		screenWidthFull = (int) width;
		screenHeightFull = (int) height;
              
	}
*/
  /**
   * Resets the game when retrying.
   */
  public void retry() {
    prisoner.setDefaultValues();
    this.aSetter.setEnemy();
    this.aSetter.setObject();
    ui.playTime = 0;
  }

  /**
   * The main game loop.
   */
  public void run() {
    double drawInterval = (1000000000 / this.FPS);
    double delta = 0.0D;
    long lastTime = System.nanoTime();
    Random rnd = new Random();
    double racount = 0;
    int ranum = 0;
    int ranx = 0;
    int rany = 0;
    long timer = 0L;
    int drawCount = 0;

    while (this.gameThread != null) {

      long currentTime = System.nanoTime();

      delta += (currentTime - lastTime) / drawInterval;
      timer += currentTime - lastTime;
      lastTime = currentTime;
      // Bonus Objects
      if (racount == 0) {
        ranum = rnd.nextInt(0, 2);
        if (ranum == 0) {
          ranum = rnd.nextInt(0, 2);
          if (ranum == 0) {
            ranx = 2;
            rany = 21;
          } else if (ranum == 1) {
            ranx = 51;
            rany = 21;
          }
          this.obj[12] = new Boots(this);
          this.obj[12].mapX = this.tileSize * ranx;
          this.obj[12].mapY = this.tileSize * rany;
        } else if (ranum == 1) {
          ranum = rnd.nextInt(0, 4);
          if (ranum == 0) {
            ranx = 51;
            rany = 2;
          } else if (ranum == 1) {
            ranx = 2;
            rany = 2;
          } else if (ranum == 2) {
            ranx = 51;
            rany = 40;
          } else if (ranum == 3) {
            ranx = 2;
            rany = 40;
          }
          this.obj[12] = new Heart(this);
          this.obj[12].mapX = this.tileSize * ranx;
          this.obj[12].mapY = this.tileSize * rany;
        }
        racount = rnd.nextInt(600000000, 900000000);
      }

      if (delta >= 1.0D) {
        update();
        /*drawToTempScreen();
        drawToScreen();
        */
       repaint();
        delta--;
        drawCount++;
      }
      racount--;
      if (timer >= 1000000000L) {

        drawCount = 0;
        timer = 0L;
      }
    }
  }

  /**
   * Updates the game state.
   */
  public void update() {
    if (gameState == playState) {
      this.prisoner.update();

      for (int i = 0; i < enemy.length; i++) {
        if (enemy[i] != null) {
          enemy[i].update();
        }
      }
    }
    if (gameState == pauseState) {
    }
  }

  /**
   * Starts the game thread.
   */
  public void startGameThread() {
    this.gameThread = new Thread(this);
    this.gameThread.start();
  }
  /*
  public void drawToTempScreen() {
	    this.tileM.create(g2);

	    for (int i = 0; i < this.obj.length; i++) {
	      if (this.obj[i] != null) {
	        this.obj[i].draw(g2, this);
	      }
	    }

	    for (int i = 0; i < this.enemy.length; i++) {
	      if (this.enemy[i] != null) {
	        this.enemy[i].draw(g2);
	      }
	    }
	    this.prisoner.draw(g2);

	    this.ui.draw(g2);

  }

  public void drawToScreen() {
	  Graphics g=getGraphics();
	  g.drawImage(tempScreen,0,0,screenWidthFull,screenHeightFull,null);
	  g.dispose();
	  
	  
  }
*/
  /**
   * Renders the game components.
   * 
   * @param g The Graphics object.
   */
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    this.tileM.create(g2);

    for (int i = 0; i < this.obj.length; i++) {
      if (this.obj[i] != null) {
        this.obj[i].draw(g2, this);
      }
    }

    for (int i = 0; i < this.enemy.length; i++) {
      if (this.enemy[i] != null) {
        this.enemy[i].draw(g2);
      }
    }
    this.prisoner.draw(g2);

    this.ui.draw(g2);

    g2.dispose();
  }
  

public Thread getGameThread() {
	return gameThread;
}

public void setGameThread(Thread gameThread) {
	 this.gameThread = gameThread;
}

public void setFPS(int FPS) {
	this.FPS = FPS;
}

}
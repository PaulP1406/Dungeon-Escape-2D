package main;
 
 import java.awt.event.KeyEvent;
 import java.awt.event.KeyListener;


/**
 * The KeyChecker class implements the KeyListener interface to handle keyboard input in the game.
 * It tracks the state of the arrow keys (up, down, left, right) and the 'P' key for pausing/resuming the game.
 * Additionally, it manages key events for the game over and game finished states, allowing the player
 * to retry the game.
 */
 public class KeyChecker implements KeyListener {
   public boolean upPressed;
   public boolean downPressed;
   public boolean leftPressed;
   public boolean rightPressed;
   public GamePanel gp;
   
   private static final int KEY_UP = KeyEvent.VK_W;
   private static final int KEY_DOWN = KeyEvent.VK_S;
   private static final int KEY_LEFT = KeyEvent.VK_A;
   private static final int KEY_RIGHT = KeyEvent.VK_D;
 
   /**
    * Constructs a KeyChecker object with the specified GamePanel instance.
    * @param gp The GamePanel instance to associate with this KeyChecker.
    */
   public KeyChecker(GamePanel gp) {
	   this.gp=gp;
   }

   /**
    * Invoked when a key is typed.
    * @param e The KeyEvent object representing the key event.
    */
   public void keyTyped(KeyEvent e) {}
   
   /**
    * Invoked when a key is pressed.
    * @param e The KeyEvent object representing the key event.
    */
   public void keyPressed(KeyEvent e) {
     int code = e.getKeyCode();

   	if (code == KeyEvent.VK_P) {
   		if (gp.gameState==gp.playState) {
   			gp.gameState=gp.pauseState;
   		}else if(gp.gameState==gp.pauseState) {
   			gp.gameState=gp.playState;
   		}

   	}
	if (gp.gameState==gp.gameOver||gp.gameState==gp.gameFinished) {
		  gameOverState(code);
	}
	   
	   setKeyState(e.getKeyCode(), true);
   }
  
   /**
    * Invoked when a key is released.
    * @param e The KeyEvent object representing the key event.
    */
  public void keyReleased(KeyEvent e) {
	  setKeyState(e.getKeyCode(), false);
  }
  
  /**
   * Sets the state of a specified key based on its key code.
   * This method is responsible for updating the state of keys (up, down, left, right)
   * to either pressed (true) or not pressed (false) based on the given key code and state.
   * 
   * @param keyCode The integer key code that identifies which key's state is being set. This should
   * correspond to one of the predefined key codes (KEY_UP, KEY_DOWN, KEY_LEFT, KEY_RIGHT).
   * @param state  True indicates the key is pressed, while false indicates it is not pressed.
   */
  private void setKeyState(int keyCode, boolean state) {
      switch (keyCode) {
          case KEY_UP:
              upPressed = state;
              break;
          case KEY_DOWN:
              downPressed = state;
              break;
          case KEY_LEFT:
              leftPressed = state;
              break;
          case KEY_RIGHT:
              rightPressed = state;
              break;         
      }
  }
  
  /**
   * Handles key events for the game over and game finished states.
   * @param code The key code associated with the key event.
   */
  public void gameOverState(int code) {
	   if(code==KeyEvent.VK_ENTER) {
		  
		   if(gp.ui.commandNum==0){
			   gp.gameState=gp.playState;
			   gp.retry();
			   }
		   }
  }
	 
 }

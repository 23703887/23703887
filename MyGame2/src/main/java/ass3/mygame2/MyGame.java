
package mygame2;


/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class is just an initiaiting class for the game to be started.
 * This class imports the game object and start the game by calling the play method
 * 
 * @author Ritika Saini
 * @version 1.0
 */


public class MyGame {

    /**
    * Entry point for the game to be started
    * This function starts the game and then it goes on untill it is quitted by user
    * @param args An option arguments params array if the program needs any starting parameters from console.
    */
    public static void main(String[] args) {
        Game game = new Game();
        game.play(); 
        
    }
    
    
    
}



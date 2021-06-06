package ass3.mygame2;


import java.util.ArrayList;


/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds information about the player who is playing the game
 * A player can have a list of items that he owns while playing the game
 * 
 * The way this is used: Players start the game and start adding stuff to their inventory
 * It also allows players to delete objects from their inventory
 * This also allows players to display their whole inventory or get a specific item from their inventory
 * 
 * @author Ritika Saini
 * @version 1.0
 */
public class Player
{
    // Player Name
    public String playerName;
    // List to hold the items of player
    private ArrayList<Item> playerItem;
    
    /**
     * Constructor to initialize player's objects
     */
    public Player()
    {
        playerItem = new ArrayList();
        playerName = 'Dummy123';
    }
    
    /**
    * This method adds the item that is passed from the main to add in the inventory.
    *
    * @param item Item that is needed to be added
    * @return nothing
    */
    
    public void addItemInventory(Item item){
        playerItem.add(item);
        System.out.println(item.getDescription() + " was taken ");
        //System.out.println(item.getDescription() + " was removed from the room"); // add extra information to inform user that the item has been taken
    }

    /**
    * This method removes the item from the inventory.
    *
    * @param item Item that is needed to be removed
    * @return nothing
    */
    public void removeItemInventory(Item item){
        playerItem.remove(item);
        System.out.println(item.getName() + " was removed from your inventory");
    }
    
    /**
    * This method returns the item that is requested by player
    *
    * @param stringItem Item name that is needed to search the item in inventory
    * @return itemToReturn Item that is requested by player
    */
    public Item getPlayerItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: playerItem){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
    
    /**
    * This method prints the whole inventory of a player
    *
    * @param none
    * @return none
    */
    public String printAllInventory(){

        String returnString = "Items:";
        for(Item item : playerItem){
            returnString += " " + item.getName();           
        }
        return returnString;
    }

    /**
     * This method sets the player name who is playing the game
     * @param inpPlayerName
     */
    public void setName(String inpPlayerName){
        name = inpPlayerName;
    }

    /**
     * This method returns the player name 
     * @return name of the player
     */
    public String getName(){
        return name;
    }
    
}

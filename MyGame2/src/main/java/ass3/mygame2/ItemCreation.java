package ass3.mygame2;

import java.util.ArrayList;


/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds the list of items that are generated and used in the game.
 * The list can contain items.
 * 
 * The way it is used: Whatever item is created in the game, it is added in the ItemCreation List
 * The list maintains the lifecycle of items that will be in the game.
 * This list serves a global object collection purpose for the game's environment.
 *
 * @author Ritika Saini
 * @version 1.0
 */
public class ItemCreation
{
    // Array list to hold the items of game
    private ArrayList<Item> allItemsInGame;
    
    /**
     * Constructor to initialize the array list for the items addition.
     * This constructor calls the second method creatItems to load some pre-defined items.
     */
    public ItemCreation()
    {       
        allItemsInGame = new ArrayList();
        createItems();
    }
    
    /**
     * This method loads some predefined items in the game
     * The items include sword and keys
     */
    public void createItems(){
        
        Item item1, item2, excaliburSword, key, frontGateKey;
        
        
        excaliburSword = new Item("excaliburSword", "The legendary Excalibur", 100);
        key = new Item("key", "It has a shape of a heart", 100);
        frontGateKey = new Item("frontGateKey", "To open the front gate door", 100);
        
        allItemsInGame.add(excaliburSword);
        allItemsInGame.add(key);
        allItemsInGame.add(frontGateKey);
    }
   
    /**
     * This method returns an item from the list
     * The method searches the item from the array list and return it's object
     * If the object is not found then NULL is returned by default.
     * 
     * @param stringItem The name of the item that is required to be searched and returned
     * @return Returns the item if it is found otherwise NULL
     */
    public Item getItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: allItemsInGame){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
  
    
}

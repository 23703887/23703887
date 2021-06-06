package ass3.mygame2;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds information about the rooms that will be involve in the game
 * A room can contain room name, description, locked information, existence map, items of room and mapping of items to the room
 * 
 * The way this is used: Rooms are created in the game in order to create an environment for the player.
 * Room will have a name, description, key and it's mapping with the items.
 * 
 * @author Ritika Saini
 * @version 1.0
 */

public class Room 
{
    // variable to hold description of room
    private String description;
    private String name; // name of the room
    private boolean isLocked; // locked information
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> roomItem; // list to hold the items of room
    private HashMap<Room, Item> roomHashMapItem; // mapping of items to the room

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param name The room's name.
     * @param description The room's description.
     * @param isLocked room is locked or not.
     */
    public Room(String name, String description, boolean isLocked) 
    {
        this.description = description;
        this.name = name;
        this.isLocked = isLocked;
        exits = new HashMap<>();
        roomItem = new ArrayList();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + ".\n" + getAllItems();
    }

    /**
     * Returns all items of room in the form of:
     *     You have some.
     *      items: 
     * @return A list of items of this room
     */
    public String getAllItems(){

        return "You have some " + listOfItems();

    }

    /**
     * Returns the name of items to the public function in the form of:
     *     items: itemname 
     * @return A list of items of this room
     */
    private String listOfItems(){

        String returnString = "items:";
        for(Item item : roomItem){
            returnString += " " + item.getName();           
        }
        return returnString;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * Method getRoomItem
     *
     * @param stringItem taken from the command which was converted into a String
     * @return Item class according to the input String
     */
    public Item getRoomItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: roomItem){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }

    /**
     * Adds the item in the list of items in room
     * @param item item to be added in the list of items for room.
     */    
    public void addItemInRoom(Item item){
        roomItem.add(item);
    }

    /**
     * Removes an item from the list of items of a room
     * @param item item that is needed to be removed.
     */
    public void removeItemInRoom(Item item){
        if(roomItem.size() > 0){
            roomItem.remove(item);
        }
    }

    /**
     * Sets the 1:1 mapping of item with the room
     * @param room The room which will be assigned to the item
     * @param item The item that needs to be attached with room
     */
    public void addHashMapItemInRoom(Room room, Item item){
        roomHashMapItem.put(room, item);
    }

    /**
     * Method getLockedStatus
     *
     * @return The return value
     */

    public boolean getLockedStatus(){
        return isLocked;
    }

    /**
     * Marks the room as Locked/Unlocked
     * @param newStatus A boolean value indicating locked/unlocked status.
     */    
    public void setLockedStatus(boolean newStatus){
        isLocked = newStatus;
    }

    /**
     * Returns the name of the room
     * @return name The name of the room.
     */    
    public String getName(){
        return name;
    }

    
}


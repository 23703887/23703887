package mygame2;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds information about the list of rooms that will be created in the game
 * The list can contain rooms.
 * 
 * The way it is used: Whatever room is created in the game, it is added in the RoomCreation List
 * The list maintains the lifecycle of rooms that will be in the game.
 * This list serves a global room collection purpose for the game's environment.
 * 
 * @author Ritika Saini
 * @version 1.0
 */

import java.util.ArrayList;

public class RoomCreation {

    // List to hold the rooms of the game
    private ArrayList<Room> allRoomInGame = new ArrayList();

    // list to hold the items of the rooms
    private ItemCreation itemCreation;

    /**
     * instantiate the rooms list
     * creates the item list
     * calls another method to load some pre-defined rooms
     */
    public RoomCreation() {
        itemCreation = new ItemCreation();
        createRooms();
    }
    
    /**
     * This function loads some predefined rooms in the game environment
     */
    private void createRooms() {

        Room castle, kitchen, frontGate;

        castle = new Room("castle", "You are at the castle", false);
        kitchen = new Room("kitchen", "The kitchen door has a shape of a heart", false);
        frontGate = new Room("frontGate", "There is a giant ogre", true);
        

        castle.setExit("east", kitchen);
        castle.setExit("south", frontGate);
        frontGate.setExit("north", castle);

        castle.addItemInRoom(itemCreation.getItem("excaliburSword"));
        castle.addItemInRoom(itemCreation.getItem("key"));
        kitchen.addItemInRoom(itemCreation.getItem("frontGateKey"));

        allRoomInGame.add(castle);
        allRoomInGame.add(frontGate);
        allRoomInGame.add(kitchen);

    }

    /**
     * This function returns the room that is requested by the player
     * 
     * @param stringRoom The name of the room that is needed by game
     * @return roomToReturn if found then the object of room that is needed to be returned
     *                      if not found then NULL
     */
    public Room getRoom(String stringRoom) {
        Room roomToReturn = null;
        for (Room room : allRoomInGame) {
            if (room.getName().contains(stringRoom)) {
                roomToReturn = room;
            }
        }
        return roomToReturn;
    }

    /**
     * This functiond adds a room in the list of rooms that are already present in the game
     * 
     * @param roomObject the object of Room class that needs to be added in the list
     */
    public void addRoom(Room roomObject)
    {
        allRoomInGame.add(roomObject);
    }

}

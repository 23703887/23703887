/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import mygame2.Item;
import mygame2.Room;
/**
 * This class is the main driver class of game "World of Zuul"
 * This class holds all the objects that will be required for gameplay
 * Game class basically sets up the environment for the game
 */

public class Game {
    // This parser reads user input and tries to interpret it as an "Adventure"
    private Parser parser;
    // This is the object of player class that will be created for person to play the gamme
    private Player player;
    // The variable for room from where the game will be started
    private Room currentRoom;
    // This is a class to hold the environment rooms for the game, basically holds all rooms of the map
    private RoomCreation rooms;

    // logical mapping of items to the rooms through hashmap
    private HashMap<Item, Room> roomItem;

    // mapping of room keys with the rooms
    private HashMap<Item, Room> roomKey;

    private int timeCounter; // to count the steps

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        long timeStart = System.currentTimeMillis(); // use the real time
        timeCounter = 50;
        parser = new Parser();
        player = new Player();
        System.out.println("Please Enter Player Name: ");
        Scanner sc= new Scanner(System.in);
        String playerName= sc.nextLine();
        player.setName(playerName);
        System.out.println("Welcome "+ player.getName() +" to World of Zuul");
        rooms = new RoomCreation();
        currentRoom = rooms.getRoom("castle");  // start game outside
        //System.out.println(createRoom.getcurrentRoom().getName());
    }
    
    /**
     * Returns the room where the player is currently present 
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    
    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        // Add new content in the game
        Item magnusShield = new Item("magnusShield", "The exotic shield", 100);
        Item magnusDagger = new Item("magnusDagger", "The exotic Dagger", 100);
        Item magnusPotion = new Item("magnusPotion", "The royal Health formula", 50.50);
        Item mainDoorkey1 = new Item("mainDoorkey1", "To open the main door of sub-castle", 100);
        Item frontGatekey2 = new Item("frontGatekey2", "To open the frontgate of sub-castle", 100);
        Item backDoorkey3 = new Item("backDoorkey3", "To Open the backdoor of sub-castle", 100);
        Room subCastle = new Room("Sub-Castle", "Castle within a castle, isn't that amazing?",true);

        // Set the subcastle exit
        subCastle.setExit("west", rooms.getRoom("kitchen"));
        subCastle.addItemInRoom(magnusShield);
        subCastle.addItemInRoom(magnusDagger);
        subCastle.addItemInRoom(magnusPotion);
        subCastle.addItemInRoom(mainDoorkey1);
        subCastle.addItemInRoom(frontGatekey2);
        subCastle.addItemInRoom(backDoorkey3);

        // add room in the game
        rooms.addRoom(subCastle);
        
        boolean finished = false;
        while (!finished) {
            long currentTime = System.currentTimeMillis();
            Command command = parser.getCommand();
            // count the delta (currentTome - startTime)            
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("some background here");
        System.out.println("objective here");
        System.out.println("include some necessary information (e.g. time limit)");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("inventory")) {
            printInventory(); // printVeggies
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("take")) {
            takeItem(command);
        } else if (commandWord.equals("drop")) {
            dropItem(command);
        } else if (commandWord.equals("use")) {
            //useItem(command);
        } else if (commandWord.equals("inspect")) {
            //lookItem(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    
    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        System.out.println("");

        // implement random Hints -> massive bonus points 
        System.out.println("you can open the door using the use command");

        System.out.println("you need to clear the ogre before you can open the kitchen door");

        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void printInventory() {
        System.out.println(player.printAllInventory());
    }

    /**
     * Try to in to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            if (currentRoom.getLockedStatus() == true) { // the door is locked
                System.out.println("The door is locked, you need to find a way to open it");
                System.out.println(currentRoom.getLongDescription());
            } else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                //System.out.println(currentRoom.printAllRoomItems());
                // increment the timeCounter
            }
        }
    }
    
    /** 
     * This function is called when the players selects an item to take
     * handles the empty take command as well
     * successful operation results in inventory update of player with the selected item
     */
    private void takeItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = currentRoom.getRoomItem(itemFromCommand);
        //getPlayerItem(itemFromCommand);

        if (currentItem == null) {
            System.out.println("You can't take nothing, no?");
        } else {
            // Do the transaction here
            player.addItemInventory(currentItem);
        }
    }
    
    /**
     * Drops a selected item from the selection while playing the game
     */
    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = player.getPlayerItem(itemFromCommand);
        //getPlayerItem(itemFromCommand);

        if (currentItem == null) {
            System.out.println("You can't take nothing, no?");
        } else {
            // Do the transaction here
            player.removeItemInventory(currentItem);
        }
    }

    /**
     * This is the function to consume an item from inventory
     * If no item is found then it gives appropriate message
     */
    private void useItem(Command command) // use key
    {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = currentRoom.getRoomItem(itemFromCommand);

        if (currentItem == null) {
            System.out.println("You can't use nothing, no?");
        } else {
            
            currentRoom.removeItemInRoom(currentItem);
            System.out.println("You just used the " + currentItem.getName());

        }

    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

}


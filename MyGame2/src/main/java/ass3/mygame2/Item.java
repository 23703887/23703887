
package mygame2;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds information about the item that are used in the game.
 * An item consists of a name, description, destructivePower, healingPower
 * If an item is an attack item then it will hold destructivePower
 * If an item is a health potion then it will hold healingPower
 * 
 * The way this is used: Items are checked for already present in the system
 * If user consumes an item that does not exist in his inventory then it is not a valid OP
 * If user adds a new item then a new obj of this class is created and added in the inventory
 * 
 * @author Ritika Saini
 * @version 1.0
 */
public class Item
{
    // Holds description about the item
    private String description;
    // variable to hold the name of an item
    private String name;
    // variable to hold the stat of destructive power of an item
    private int destructivePower;
    // variable to save the healing power of item
    private double healingPower;
    
    /**
     * Parameterized constructor to initiate an attack Item object
     * Creates an item with the given name, description and destructivePower
     * @param name The name of the attack item
     * @param description Description about the attack item
     * @param destructivePower The stat of the attack item which will indicate that how much damage will it do
     */
    public Item(String name, String description, int destructivePower)
    {
        this.name = name;
        this.description = description;
        this.destructivePower = destructivePower;
    }
    
    /**
     * Parameterized constructor to initiate an healing Item object
     * Creates an item with the given name, description and healingPower
     * @param name The name of the healing item
     * @param description Description about the healing item
     * @param healingPower The stat of the healing item which will indicate that how much health will it heal.
     */
    public Item(String name, String description, double healingPower)
    {
        this.name = name;
        this.description = description;
        this.healingPower = healingPower;
    }
    
    /** 
     * @return returns the name of item
     */
    public String getName(){
        return name;
    }
    
    /** 
     * @return returns the description of item
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * @return returns the destructivePower of an item 
     */
    public int getPower(){
        return destructivePower;
    }

    /**
     * @return returns the healingPower of an item 
     */
    public double getHealingPower(){
        return healingPower;
    }

    /** 
     * updates/set the name of an item
     * @param inpName
     */
    public void setName(String inpName){
        name = inpName;
    }
    
    /** 
     * updates/set the description of an item
     * @param inpDescription
     */
    public void setDescription(String inpDescription){
        description = inpDescription;
    }
    
    /**
     * updates/set the destructivePower of an item
     * @param inpdestructivePower 
     */
    public void setPower(int inpdestructivePower){
        destructivePower = inpdestructivePower;
    }

    /**
     * updates/set the healingPower of an item
     * @param inphealingPower
     */
    public void setHealingPower(double healingPower){
        healingPower = healingPower;
    }
    
}

package mygame2;
/**
 * This class is to implement the unit testing to check the functionalities of classes
 * 
 * @author Ritika Saini
 * @version 1.0
 */

import org.junit.Test;

import junit.framework.TestCase;

import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class UnitTest extends TestCase {

   /**
    * 1 - Test method to test the item name set
    */
   public void testItemSet(){
        Item excaliburSword = new Item("excaliburSword", "The legendary Excalibur", 100);
        assertEquals(excaliburSword.getName(),"excaliburSword");
   }

   /**
    * 2 - Test method to test the item set name method
    */
    public void testItemNameSet(String defaultName, String newName){
        Item excaliburSword = new Item(defaultName, "The legendary Excalibur", 100);
        excaliburSword.setName(newName);
        assertEquals(excaliburSword.getName(),newName);
   }

   /**
    * 3 - Test method to test the item set description method
    */
    public void testItemDescriptionSet(String defaultdescription, String newdescription){
        Item excaliburSword = new Item("excaliburSword", defaultdescription, 100);
        excaliburSword.setDescription(newdescription);
        assertEquals(excaliburSword.getDescription(),newdescription);
   }

   /**
    * 4 - Test method to test the item destructivePower set
    */
    public void testItemPowerSet(int defaultPower, int newPower){
        Item excaliburSword = new Item("excaliburSword", "The legendary Excalibur", defaultPower);
        excaliburSword.setPower(newPower);
        assertEquals(excaliburSword.getPower(),newPower);
   }

    /**
    * 5 - Test method to test the item healingPower set
    */
    public void testItemPowerSet(double defaultHealingPower, double newHealingPower){
        Item excaliburSword = new Item("excaliburSword", "The legendary Excalibur", defaultHealingPower);
        excaliburSword.setHealingPower(newHealingPower);
        assertEquals(excaliburSword.getHealingPower(),newHealingPower);
   }

    /**
    * 6 - Test method to test the room set method
    */
    public void testRoomSet(){
        Room subCastle = new Room("subcastle", "You are at the subcastle", false);
        assertEquals(subCastle.getName(),"subcastle");
   }
}
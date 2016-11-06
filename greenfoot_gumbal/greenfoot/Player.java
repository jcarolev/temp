import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    // 0 index will be left, 1 index will be right
    private Gumball leftHandObj;
    private Gumball rightHandObj;
    
    private Gumball[] gumballs = new Gumball[2];

    public Player(GumballType leftHandObjectType, GumballType rightHandObjectType)
    {
        GreenfootImage image = getImage() ;
        image.scale( 100, 130 ) ;
        
        if(leftHandObjectType != null){
            leftHandObj = GumballFactory.generateGumball(leftHandObjectType);
            leftHandObj.setOwner(this);
        }
        if(rightHandObjectType != null){
             rightHandObj = GumballFactory.generateGumball(rightHandObjectType);
             rightHandObj.setOwner(this);
        }
    }
   
    public void act() 
    {
        // Add your action code here
        World myWorld = getWorld();
        if(leftHandObj != null){
            myWorld.addObject(leftHandObj, getX()-50, getY()+50);
        }
        if(rightHandObj != null){
            myWorld.addObject(rightHandObj, getX()+50, getY()+50);
        }
    }
   
    public void draw()
    {
        
    }
    public boolean isMyNeighbor(Player player){
        World mW = getWorld();
        OrangeGameWorld myWorld = (OrangeGameWorld) mW;
        return myWorld.checkingNeighborhood(this, player);
    }
    
    //will return 0 if lefthand is available , return 1 if righthand available, retunr -1 if bothhands not avaialble
    public HandType whichHandAvailable()
    {
        if(leftHandObj == null)
            return HandType.LEFT;
        if(rightHandObj == null)
            return HandType.RIGHT;
        return null;
    }
    
    
    public void releaseObjFromHand(HandType hand)
    {
        switch(hand)
        {
            case LEFT:  leftHandObj = null;break;
            case RIGHT: rightHandObj = null;break;
        }
    }
    
    public void putObjectIntoHand(Gumball object, HandType hand)
    {
        switch(hand)
        {
            case LEFT:  leftHandObj = object;break;
            case RIGHT: rightHandObj = object;break;
        }
    }
    
    public HandType isObjectBelongTo(Gumball obj)
    {
        if(obj == leftHandObj)
            return HandType.LEFT;
        else if(obj == rightHandObj)
            return HandType.RIGHT;
        return null;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class OrangeGameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrangeGameWorld extends World
{

    /**
     * Constructor for objects of class OrangeGameWorld.
     * 
     */
    
    private Orientation orientation;
    private ArrayList<Player> players = new ArrayList<Player>();
    
    public OrangeGameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        orientation = new LineLayout();
        prepare();
        //orientation.drawLayout();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    
    
    private void prepare()
    {
        signUp();
        
        for(int i = 0 ; i < players.size() ; i ++){
            addObject(players.get(i), orientation.getPositionXForPlayerAt(i), 
                                                orientation.getPositionYForPlayerAt(i));
        }
        
    }
    
    public void signUp()
    {
        GumballType[] gumballTypes = {GumballType.RED,GumballType.GREEN,GumballType.BLUE
                                        ,GumballType.PURPLE,GumballType.YELLOW};
        
        int position = 2;
        for(int i = 0 ; i < 5; i++)
        {
            Player player = null;
            if(i == position)
                player = new Player(gumballTypes[i],null);
            else
                player = new Player(gumballTypes[i],gumballTypes[i]); 
            players.add(player);
        }
        orientation.addPlayers(players);
    }
    
    public boolean checkingNeighborhood(Player player1, Player player2)
    {
        return orientation.checkingNeighborHood(player1, player2);
    }
}

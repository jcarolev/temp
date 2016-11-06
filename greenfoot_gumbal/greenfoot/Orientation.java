/**
 * Write a description of class Orientation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
import java.util.*;

public interface Orientation  
{
    // instance variables - replace the example below with your own
    void addPlayers(ArrayList<Player> players);
    boolean checkingNeighborHood(Player player1, Player player2);
    int getPositionXForPlayerAt(int i);
    int getPositionYForPlayerAt(int i);
}

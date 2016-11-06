/**
 * Write a description of class LineLayout here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*; 
import java.util.*;

public class LineLayout implements Orientation
{
    // instance variables - replace the example below with your own
    private DoublyLinkedList<Player> list ;
    
    public LineLayout()
    {
        list = new DoublyLinkedList<Player>();
    }
    
    public void addPlayers(ArrayList<Player> players){
        for(Player player : players)
        {
            list.add(player);
        }
    }
    
    public boolean checkingNeighborHood(Player player1, Player player2)
    {
        DoublyLinkedList.Node head = list.getHead().getNext();
        while(head !=null)
        {
            Player player = (Player)head.getItem();
            if(player1 == player){
                //check to see if palyer is obe of my neighbors
                Player pre =(Player) head.getPrev().getItem();
                Player pos =(Player) head.getNext().getItem();
                if(player2 == pre) return true;
                if(player2 == pos) return true;
            }
            head = head.getNext();
        }
        return false;
    }
   
   public int getPositionXForPlayerAt(int i)
   {
       return 100 + 160 * i;
   }
    
   public int getPositionYForPlayerAt(int i)
   {
       return 300;
   }
    
}

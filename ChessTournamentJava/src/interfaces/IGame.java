/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Player;
import models.Clock;
/**
 *
 * @author George.Pasparakis
 */
public interface IGame {
    /*
        - uses the two players
        - each player moves one after the other
    */
    public void start(Player[] players);
    
     void playersMove(Player[] players, Clock c); 
//    public String gameState(Player[]players);
//    public String takeTurns(Player[] players, int time); 
//    public int startClock(Player[] players, int turn);
//    public void gameStart(Player p1, Player p2);
//    public int gameIsOn(int counter);
//    public int gameDuration(Player[] players, Clock c);
    
    public static String dummy() {
//        System.out.println("dfdfsdf");
        return("");
    }
}

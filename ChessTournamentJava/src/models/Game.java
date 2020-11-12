/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import interfaces.IGame;
/**
 *
 * @author George.Pasparakis
 */
public class Game extends Naming implements IGame {
    private Player[] players;
    private final int timer = 600;

    public  Game() {
       System.out.println("Game 1");
    }
    
    public Game(String name, Player[] players) {
        this.setName(name);
        this.start(players);
    }
    
    public void start(Player[] players) {
        System.out.println(this.getName());
        System.out.println("Player " + players[0] + " plays against Player "
                                     + players[1]);
        System.out.println("Starting time is: "+ timer);
        this.players = players;
        this.playersMove(players, new Clock());

    }

    public void playersMove(Player[] players, Clock c) {
        // Player X plays move m against Player Y
        // 15" * 4 = 1' * 10 = 10' == 600"
        //600" = 40 cycles, 20 cycles
        int gameTimer = 600;
        for (int i = 0; i < 20; i++) {

            System.out.println("Player " + players[0] + " plays move "
                    + players[0].moves(this)
                    + " against Player " + players[1]);

            gameTimer -= 15;
            System.out.println("Time after player " + players[0] +" move is: " + gameTimer);
            // Player X plays move m against Player Y
            System.out.println("Player " + players[1] + " plays move "
                    + players[1].moves(this)
                    + " against Player " + players[0]);
            gameTimer -= 15;
            System.out.println("Time after player " + players[0] +" move is: " + gameTimer);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.List;
import java.util.ArrayList;
import interfaces.ITournament;

        
/**
 *
 * @author George.Pasparakis
 */
public class Tournament extends Naming implements ITournament {
    private Game[] games; // = { new Game("Game 1"), new Game("Game 2"), new Game("Game 3") }; 
    private List<Player> players = new ArrayList<Player>(); // polymorphism
    // ArrayList<Player> players2 = new ArrayList<Player>();
            
    // default
    public Tournament() {
        System.out.println("Welcome to the Ultimate Chess Tournament 2020");
    }
    
    // overloaded
    public Tournament(String name) {
        this.setName(name);
        this.startTournament();
       
        
//        Player playersPerGame[] = new Player[] { players.get(0), players.get(1)};
//        
//        // Game 1 - Paspa - Gasparov
//        playersPerGame[0] = players.get(0);
//        playersPerGame[1] = players.get(1);
        
        
        
//        Game game = new Game("Game 1");
//        Game game1 = new Game("Game 2");
//        Game game2 = new Game("Game 3");

//        games[0] = new Game("Game 1");
//        games[1] = new Game("Game 2");
//        games[2] = new Game("Game 3");

//        Player p = new Player("Paspa");
        
    }
    
    public void startTournament() {
        System.out.println("Welcome to the " + getName());
        introducePlayers(players);
        games = new Game[] { new Game("Game 1", new Player[] { players.get(0), players.get(1)}), 
                             new Game("Game 2", new Player[] { players.get(0), players.get(2)}), 
                             new Game("Game 3", new Player[] { players.get(0), players.get(3)})};
    }
    
    public void introducePlayers(List<Player> players) {
        System.out.print(this.getName() + " introduces ");
        players.add(new Player("Paspa"));
        
        System.out.print(this.getName() + " introduces ");
        players.add(new Player("Gasparov"));
        
        System.out.print(this.getName() + " introduces ");
        players.add(new Player("Karpov"));
        
        System.out.print(this.getName() + " introduces ");
        players.add(new Player("Medved"));
    }
}

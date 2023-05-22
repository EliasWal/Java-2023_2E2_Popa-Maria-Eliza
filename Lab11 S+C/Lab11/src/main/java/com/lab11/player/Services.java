package com.lab11.player;

import io.swagger.annotations.ApiParam;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elias
 */
@Service
public class Services {
   
    
    private List<Player> players;
    
    public Services(){
        players = new ArrayList();
        Player player1 = new Player("Player1",'X', 1);
        Player player2 = new Player("Player2",'O', 2);
        Player player3 = new Player("Player3",'Z', 3);

        players.add(player1);
        players.add(player2);
        players.add(player3);
    }
    
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    void addPlayer(@ApiParam("Player object") Player player) {
        players.add(player);
    }
    
    boolean updatePlayer(@ApiParam("Player ID") int id,@ApiParam("Updated player object")  Player player) {
        for(Player p : players){
            if(p.getId() == id){
                p.setNume(player.getNume());
                p.setSymbol(player.getSymbol());
                p.setId(player.getId());
                return true;
            }
        }
        return false;
    }
    
    boolean deletePlayer(@ApiParam("Player ID")int id) {
        for (Player p : players) {
            if (p.getId() == id) {
                players.remove(p);
                return true;
            }
        }
        return false;
    }  
    
}

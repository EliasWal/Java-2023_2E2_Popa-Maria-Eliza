package com.lab11.player;

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
    
    
}

package com.lab11.Game;

import com.lab11.player.Player;
import java.util.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elias
 */
@Service
public class GameService {
    private List<Game> games;
    
    public GameService(){
        games = new ArrayList<>();
        
        Player player1 = new Player("Player1",'X', 1);
        Player player2 = new Player("Player2",'O', 2);
        Player player3 = new Player("Player3",'Z', 3);

        games.add(new Game("1", player1, player2));
        games.add(new Game("2", player2, player3));
        games.add(new Game("3", player1, player3));
    }
    
    public List<Game> getGames(){
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
    
    
}

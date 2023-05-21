package com.ClientAppLab11;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.ClientAppLab11.Player;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Elias
 */

@Component
public class GameClient {
    private static final String SERVER_URL = "http://localhost:8000";

    @Autowired
    private RestTemplate restTemplate=new RestTemplate();

    public void addPlayer(String name, char symbol, int id) {
        Player player = new Player(name, symbol , id);
        ResponseEntity<Player> response = restTemplate.postForEntity(
                SERVER_URL + "/players",
                player,
                Player.class
        );
        System.out.println("Player added: " + response.getBody());
    }
    
    public void deletePlayer(int playerId){
        restTemplate.delete(SERVER_URL + "/players/{id}", playerId);
        System.out.println("Player deleted: " + playerId);
    }
    public void modifyName(int playerId, String name){
        Player player = restTemplate.getForObject(
                SERVER_URL + "/players/{id}", 
                Player.class, 
                    playerId
        );
        if (player != null) {
            player.setNume(name);
            restTemplate.put(SERVER_URL + "/players/{id}", player, playerId);
            System.out.println("Player name modified: " + player);
        } else {
            System.out.println("Player not found with ID: " + playerId);
        }
    }
    
    public void getGames() {
        ResponseEntity<List<Game>> response = restTemplate.exchange(
                SERVER_URL + "/games",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Game>>() {}
        );

        List<Game> games = response.getBody();
        if (games != null) {
            for (Game game : games) {
                System.out.println("Game ID: " + game.getId());
                System.out.println("Player 1: " + game.getPlayer1().getNume());
                System.out.println("Player 2: " + game.getPlayer2().getNume());
                System.out.println("---------");
            }
        } else {
            System.out.println("No games found.");
        }
    }


}

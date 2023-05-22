package com.ClientAppLab11;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.ClientAppLab11.Player;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    final Logger log = LoggerFactory.getLogger(GameClient.class);
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
    public void modifyName(int playerId, String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Player player = new Player();
        player.setNume(name);

        HttpEntity<Player> requestEntity = new HttpEntity<>(player, headers);

        ResponseEntity<Player> response = restTemplate.exchange(
            SERVER_URL + "/players/{id}",
            HttpMethod.PUT,
            requestEntity,
            Player.class,
            playerId
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            Player newPlayer = response.getBody();
            System.out.println("Player name modified: " + newPlayer);
        } else {
            System.out.println("Failed to modify player name. Status code: " + response.getStatusCodeValue());
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
      
        for (Game game : games)
            System.out.println(game.toString());
        
//        games.forEach(p -> log.info(p.toString()));
//        log.info("Stop");
//        return games;
    }


}

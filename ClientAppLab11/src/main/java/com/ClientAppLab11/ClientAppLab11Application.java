package com.ClientAppLab11;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientAppLab11Application {

        public static void main(String[] args) {
        SpringApplication.run(ClientAppLab11Application.class, args);
        GameClient gameClient=new GameClient();
//        gameClient.addPlayer("John", 'X', 1);
//        gameClient.addPlayer("Doe", '0', 2);
//        gameClient.addPlayer("Maggie", '0', 3);
//        gameClient.deletePlayer(1);
//        gameClient.deletePlayer(3);
//        gameClient.deletePlayer(1);
//        gameClient.deletePlayer(3);'
//          gameClient.modifyName(3, "Maddie");
        gameClient.getGames();
        }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

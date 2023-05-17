package com.lab11.player;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elias
 */

@RestController
public class Controller {
    private Services services;
    @Autowired
    public Controller(Services services){
        this.services = services;
    }
    @GetMapping("/")
    public List<Player> getPlayers(){
        return services.getPlayers();
    }
}

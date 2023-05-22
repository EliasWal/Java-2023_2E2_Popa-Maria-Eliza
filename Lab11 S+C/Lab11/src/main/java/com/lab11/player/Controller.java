package com.lab11.player;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Elias
 */

@RestController
@RequestMapping("/players")
@Api(tags = "Players")
public class Controller {
    private final Services services;
     
    private Player player;
    
    @Autowired
    public Controller(Services services){
        this.services = services;
    }
    
    @GetMapping
    @ApiOperation("Get all players")
    public List<Player> getPlayers(){
        return services.getPlayers();
    }
    
    @PostMapping
    @ApiOperation("Add all players")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        services.addPlayer(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    @ApiOperation("Update player's name")
    public ResponseEntity<Player> updatePlayer(@PathVariable int id, @RequestBody Player player) {
        boolean updated = services.updatePlayer(id, player);
        if (updated) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation("Delete player by id")
    public ResponseEntity<Void> deletePlayer(@PathVariable int id) {
        boolean deleted = services.deletePlayer(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/error")
    @ApiOperation("Handle custom 404 error")
    public ResponseEntity<String> handle404Error() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Custom 404 Error Message");
    }
    
}

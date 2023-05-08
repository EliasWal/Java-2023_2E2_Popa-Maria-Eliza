package com.mycompany.lab9;

import entities.Album;
import entities.Artist;
import entities.PersistenceManager;
import javax.persistence.*;
import repositories.AlbumRepository;

/**
 *
 * @author Elias
 */
public class Lab9 {

    public static void main(String[] args) {
        
        Artist artist = new Artist("Beatles");
        
        AlbumRepository albums = new AlbumRepository();
        System.out.println(albums.findByArtist(artist));
        
    }
}

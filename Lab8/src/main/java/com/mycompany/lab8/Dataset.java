package com.mycompany.lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elias
 */
public class Dataset {
    Connection con = Database.getConnection();
   
    private List<AlbumDAO> albums;
     public Dataset(String filename) throws IOException {
        albums = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        while (line != null) {
            String[] fields = line.split(",");
            int year = 0;
            String name = fields[1];
            String artist = fields[2];
            String genre = fields[3];
            AlbumDAO album = new AlbumDAO();
            album.create(year, name, artist, genre);
            albums.add(album);
            line = reader.readLine();
        }
        reader.close();
    }

    public List<AlbumDAO> getAlbums() {
        return albums;
    }

}

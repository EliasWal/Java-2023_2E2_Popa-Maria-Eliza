package entities;

import javax.persistence.*;

/**
 *
 * @author Elias
 */

@Entity
@Table(name = "albums")
@NamedQueries({
    @NamedQuery(name = "Album.findAll",
            query = "select e from Album e order by e.title"),
    @NamedQuery(name = "Album.findByArtist",
            query = "select e from Album e where e.artist = ?1"),
 
})
public class Album {

    @Basic(optional = false)
    @Column(name = "year")
    private int year;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    
    @Column(name = "artist")
    private String artist;
    
    @Column(name = "genre")
    private String genre;

    public Album(Integer id, Integer year, String artist, String genre) {
        this.id = id;
        this.year = year;
        this.artist = artist;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", year=" + year + ", artist=" + artist + ", genre=" + genre + '}';
    }

    public Album() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}

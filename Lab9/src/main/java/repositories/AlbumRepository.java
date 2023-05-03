package repositories;

import entities.Album;
import entities.Artist;
import java.util.*;
import javax.persistence.EntityManager;
import org.dom4j.tree.AbstractEntity;
/**
 *
 * @author Elias
 */
public class AlbumRepository extends DataRepository<Album, Integer>   {
    private  final EntityManager em =; //create it somehow
    public List<Album> findByArtist(Artist artist) {
    return em.createNamedQuery("Album.findByArtist")
    .setParameter("artist", artist)
    .getResultList();
    }
    
    public void create(Album album){
        
    }
    
    public String findById(int id){
        return null;
    }
    
    /**
     *
     * @param name
     * @return
     */
    @Override
    public Integer findByName(String name){
                
        
        return null;
                
        
    }
   // public  
    
    
}

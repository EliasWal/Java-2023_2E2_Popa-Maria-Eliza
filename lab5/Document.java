package com.mycompany.lab5;
import java.util.stream.*;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Elias
 */
public class Document implements Serializable {

    
    private String id;
    private String title;
    private String location;
    
    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }
    
    private Map<String, Object> tags = new HashMap<>();
    
    public void addTag(String key, Object obj){
        tags.put(key , obj);
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Document id: ").append(id).append("\n");
        stringBuilder.append("Document name: ").append(title).append("\n");
        stringBuilder.append("Document location: ").append(location).append("\n");
        stringBuilder.append("Tags: ").append(tags).append("\n");
        return stringBuilder.toString();
    }
    
}

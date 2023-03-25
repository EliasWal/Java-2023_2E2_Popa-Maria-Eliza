package com.mycompany.lab4;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Elias
 */
public class Matching{
    
    private Map<Students, List<Projects>> prefMap;

    public Matching() {
        
        prefMap= new HashMap<>();
        
    }
    public void addPreference(Students students, Projects... projects) {
        prefMap.put(students, Arrays.asList(projects));
    }
    

    public Map<Students, List<Projects>> getPrefMap(Students student) {
        return prefMap;
    }

       public void printPreferenceMap() {
        for (Map.Entry<Students, List<Projects>> entry : prefMap.entrySet()) {
            Students student = entry.getKey();
            List<Projects> projectsList = entry.getValue();
            System.out.println("Projects preferred by " + student.getName() + ": " + projectsList);
        }
    }
       //method for displaying the students  that have a number of preferences 
       //lower than the average number of preferences
       public void Average(){
            double avgNum = prefMap.values()
                .stream()
                .mapToInt(List::size)
                .average()
                .orElse(0.0);

            System.out.println(avgNum);
       
            prefMap.keySet()
               .stream()
               .filter(student -> prefMap.get(student).size() < avgNum)
               .forEach(System.out::println);
       
        }
       
public void greedyMatch() {
        Map<Projects, Students> matching = new HashMap<>();
        Set<Projects> availableProjects = new HashSet<>();
        availableProjects.addAll(prefMap.values().stream().flatMap(List::stream).collect(Collectors.toList()));

        for (Students student : prefMap.keySet()) {
            for (Projects project : prefMap.get(student)) {
                if (availableProjects.contains(project)) {
                    matching.put(project, student);
                    availableProjects.remove(project);
                    break;
                }
            }
        }

        System.out.println("Matching:");
        for (Map.Entry<Projects, Students> entry : matching.entrySet()) {
            Projects project = entry.getKey();
            Students student = entry.getValue();
            System.out.println(student.getName() + " - " + project.getName());
        }
    }



      
}

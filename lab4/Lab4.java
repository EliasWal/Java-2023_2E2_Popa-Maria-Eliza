package com.mycompany.lab4;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.*;

public class Lab4 {

    public static void main(String[] args) {
        
    //creating Student objects using streams    
        var students = IntStream.rangeClosed(0, 2)
                         .mapToObj(i -> new Students("S" + i) )
                         .toArray(Students[]::new);

        //creating projects objects using streams 
        var projects = IntStream.rangeClosed(0, 2)
                          .mapToObj(i -> new Projects("P" + i) )
                          .toArray(Projects[]::new);

        
         Matching prefMap = new Matching();
         prefMap.greedyMatch();
         //list of students
        LinkedList<Students> studentList = new LinkedList<>();
        studentList.addAll(Arrays.asList(students));
        
        //list of projects, already listed because is a TreeSet
        TreeSet<Projects> projectSet = new TreeSet<>();
        projectSet.addAll(Arrays.asList(projects));
       
        //sorted list of students
        List<Students> newSortedList = studentList.stream()
         .sorted(Comparator.comparing(Students::getName))
         .collect(Collectors.toList());      
        
        System.out.println("Printing the LinkedList");
        for( Students student : newSortedList)
        {
           System.out.println(student);
        }
        
        System.out.println();
        
        System.out.println("Printing the TreeSet");
        for( Projects project : projectSet)
        {
           System.out.println(project);
        }    
        
        System.out.println();

        prefMap.addPreference(students[0], projects[0], projects[1], projects[2]);
        prefMap.addPreference(students[1], projects[0], projects[1]);
        prefMap.addPreference(students[2], projects[0]);
        
        //Faker third-party library
        Faker faker = new Faker();

        for (Students student : newSortedList) {
            String newName = faker.name().fullName();
            student.setName(newName);
        }
        
        for (Projects project : projectSet) {
            String newName = faker.app().name();
            project.setName(newName);
        }
        
        System.out.println("Print preference map");

        prefMap.printPreferenceMap();
        
        System.out.println();
        
        System.out.println("Print average");

        prefMap.Average();
     
        
        System.out.println("Print Matching");
        prefMap.greedyMatch();

    }
}

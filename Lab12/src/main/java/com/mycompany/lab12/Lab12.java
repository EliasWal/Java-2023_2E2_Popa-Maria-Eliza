/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab12;

/**
 *
 * @author Elias
 */
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Lab12 {

    public static void main(String[] args) throws Exception {
        Loader loader = new Loader();
        String pathJar = "C:\\Users\\Elias\\Desktop\\Facultate\\An II Sem 2\\JAVA\\Lab12\\target\\Lab12-1.0-SNAPSHOT.jar";
        String pathDir = "C:\\Users\\Elias\\Desktop\\Facultate\\An II Sem 2\\JAVA\\Lab12\\target\\Lab12-1.0-SNAPSHOT.jar";
        
        loader.fileChecker(pathJar);
        loader.getPackages();
        loader.getMethods();
        loader.invokeMethods();
        
        System.out.println();
        
        loader.fileChecker(pathDir);
        loader.getPackages();
        loader.getMethods();
        loader.invokeMethods();
                
    }
}

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
        String path = "C:\\Users\\Elias\\Desktop\\Facultate\\An II Sem 2\\JAVA\\Lab12\\tagert\\Lab12 - 1.0 - SNAPSHOT.jar";
        loader.fileChecker(path);
        //loader.getPackages();
        loader.getMethods();
        loader.invokeMethods();
                
    }
}
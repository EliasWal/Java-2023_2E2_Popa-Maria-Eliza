package com.mycompany.lab12;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/**
 *
 * @author Elias
 */

import org.testng.annotations.Test;

public class Loader {
    ClassLoader classLoader;
    Class<?> clazz;
    
    public void loadClassByName(String classFilePath) throws Exception {
        File file = new File(classFilePath);
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};
        classLoader = new URLClassLoader(urls);
        String searchedFile = "com.mycompany.lab12.TestClass";
        clazz = classLoader.loadClass(searchedFile);
    }
    
    public void fileChecker(String filePath) throws Exception{
        File file = new File(filePath);
        if(file.isDirectory()){
            loadClassFromDirectory(file);
        }
        else 
            if(file.isFile() && file.getName().endsWith(".jar")){
                loadClassFromJar(file);
            }
    }
    
    public void getPackages(){
        Package classPackage = clazz.getPackage();
        System.out.println("Package: " + classPackage);
    }
    
     public void getMethods(){
        StringBuilder stringBuilder = new StringBuilder("Methods: ");
        for (Method method : clazz.getMethods()) {
            method.setAccessible(true);
            stringBuilder.append(method.getName()).append(", ");
        }
        System.out.println(stringBuilder);
    }
     
    public void invokeMethods(){
        for (Method method : clazz.getMethods()) {
            method.setAccessible(true);
            Annotation testAnnotation = method.getDeclaredAnnotation(Test.class);
            if (testAnnotation != null && method.getParameterCount() == 0) {
                try {
                    Object result = method.invoke(null);
                    System.out.println("Invoked method: " + method.getName());
                    System.out.println("Result: " + result);
                } 
                catch (IllegalAccessException | InvocationTargetException e) {}   
            }
        }
    }
    
    private void loadClassFromDirectory(File directory) throws Exception {
        File[] files = directory.listFiles();
        if(files != null){
            for(File file:files){
                if(file.isDirectory()){
                    loadClassFromDirectory(file);
                }
                else 
                    if(file.isFile() && file.getName().endsWith(".class")){
                        loadClass(file);
                    }
            }
        }
    }
    

    private void loadClassFromJar(File jarFile) throws Exception {
        JarFile jar = new JarFile(jarFile);
        List<Class<?>> classes = new ArrayList<>();
        
        for(JarEntry entry : Collections.list(jar.entries())){
            if (entry.getName().endsWith(".class")) {
                String className = entry.getName().replace('/', '.').replace(".class", "");
                Class<?> loadedClass = classLoader.loadClass(className);
                classes.add(loadedClass);
            }
        }
        for (Class<?> loadedClass : classes) {
        clazz = loadedClass;
        }
        jar.close();
    }

    private void loadClass(File file) throws Exception {
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};
        classLoader = new URLClassLoader(urls);
        String className = file.getAbsolutePath()
                .replace(".class", "")
                .replace(File.separator, ".");
        className = className.substring(className.indexOf("com"));
        clazz = classLoader.loadClass(className);

    }
    
   
}

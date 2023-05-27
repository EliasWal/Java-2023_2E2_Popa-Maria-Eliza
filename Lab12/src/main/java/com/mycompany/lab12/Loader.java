package com.mycompany.lab12;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
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
    private int totalTests;
    private int passedTests;
    private int failedTests;
    
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
            if(file.getName().endsWith(".jar")){
                classLoader = getClass().getClassLoader();
                loadClassFromJar(file);
                List<Class<?>> loadedClasses = loadClassFromJar(file);
                if (!loadedClasses.isEmpty()) {
                    clazz = loadedClasses.get(loadedClasses.size() - 1);
                }
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
     
     public void getFields(){
         StringBuilder stringBuilder = new StringBuilder("Fields: ");
         for (Field field : clazz.getFields()) {
            field.setAccessible(true);
            stringBuilder.append(field.getName()).append(", ");
        }
        System.out.println(stringBuilder);
     }

     public void getConstructors() {
        Constructor<?>[] constructors = clazz.getConstructors();

        if (constructors.length > 0) {
            System.out.println("Constructors:");
            for (Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);
                System.out.println(constructor.toString());
            }
        } else {
            System.out.println("No constructors found.");
        }
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
    

    private List<Class<?>> loadClassFromJar(File jarFile) throws Exception {
        JarFile jar = new JarFile(jarFile);
        List<Class<?>> classes = new ArrayList<>();
        
        for(JarEntry entry : Collections.list(jar.entries())){
            if (entry.getName().endsWith(".class")) {
                String className = entry.getName().replace('/', '.').replace(".class", "");
                Class<?> loadedClass = classLoader.loadClass(className);
//                System.out.println(className);
                classes.add(loadedClass);
            }
        }
        jar.close();
        return classes;
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
    public void invokeTestMethods() {
        resetStatistics();
        if (clazz != null) {
            System.out.println("Invoking @Test methods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class) && Modifier.isPublic(method.getModifiers())) {
                    invokeTestMethod(method);
                }
            }
        } else {
            System.out.println("No class loaded.");
        }
        printStatistics();
    }
    
    private void invokeTestMethod(Method method) {
        try {
            List<Object> arguments = generateMockArguments(method.getParameterTypes());
            Object result = method.invoke(null, arguments.toArray());
            System.out.println("Invoked method: " + method.getName());
            System.out.println("Result: " + result);
            passedTests++;
        } catch (Exception e) {
            System.out.println("Failed to invoke method: " + method.getName());
            e.printStackTrace();
            failedTests++;
        }
        totalTests++;
    }
    private List<Object> generateMockArguments(Class<?>[] parameterTypes) {
        List<Object> arguments = new ArrayList<>();
        for (Class<?> parameterType : parameterTypes) {
            if (parameterType.equals(int.class)) {
                arguments.add(0);
            } else if (parameterType.equals(String.class)) {
                arguments.add("mock");
            } else {
                arguments.add(null); 
            }
        }
        return arguments;
    }
    private void printStatistics() {
        System.out.println("\nTest Statistics:");
        System.out.println("Total Tests: " + totalTests);
        System.out.println("Passed Tests: " + passedTests);
        System.out.println("Failed Tests: " + failedTests);
    }
    
    private void resetStatistics() {
        totalTests = 0;
        passedTests = 0;
        failedTests = 0;
    }
    
    
}

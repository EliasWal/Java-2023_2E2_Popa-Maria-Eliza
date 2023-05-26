package com.mycompany.lab12;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
/**
 *
 * @author Elias
 */

import org.testng.Assert;
import org.testng.annotations.Test;

public class Loader {
    public void loadClassByName(String classFilePath) throws Exception {
        File file = new File(classFilePath);
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};
        ClassLoader classLoader = new URLClassLoader(urls);
        
        String searchedFile = "com.mycompany.lab12.TestClass";

        Class<?> clazz = classLoader.loadClass(searchedFile);

    Package classPackage = clazz.getPackage();

        System.out.println("Package: " + classPackage);

        StringBuilder stringBuilder = new StringBuilder("Methods: ");
//        Class<?> clazz = classLoader.loadClass(searchedFile);
        for (Method method : clazz.getMethods()) {
            method.setAccessible(true);
            stringBuilder.append(method.getName()).append(", ");
            Annotation testAnnotation = method.getDeclaredAnnotation(Test.class);
            if (testAnnotation != null && method.getParameterCount() == 0) {
                try {
                    Object result = method.invoke(null);
                    System.out.println("Invoked method: " + method.getName());
                    System.out.println("Result: " + result);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(stringBuilder);

    }

}

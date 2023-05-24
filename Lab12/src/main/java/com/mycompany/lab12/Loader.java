package com.mycompany.lab12;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author Elias
 */

import org.testng.Assert;

public class Loader {
    public void loadClassByName() throws Exception {
        File file = new File("C:\\Users\\Elias\\Desktop\\Facultate\\An II Sem 2\\JAVA\\Lab12\\src\\main\\java\\com\\mycompany\\lab12");
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};
        ClassLoader classLoader = new URLClassLoader(urls);
        String searchedFile = "com.mycompany.lab12.TestClass";
        Package classPackage = Class.forName(searchedFile).getPackage();
        System.out.println("Package: " + classPackage);

        StringBuilder stringBuilder = new StringBuilder("Methods: ");
        for (Method method : Class.forName(searchedFile).getMethods()) {
            method.setAccessible(true);
            stringBuilder.append(method.getName()).append(", ");
        }
        System.out.println(stringBuilder);

        Class<?> clazz = classLoader.loadClass(searchedFile);
        Method method = clazz.getDeclaredMethod("sayHello");
        method.setAccessible(true);

        Object result = method.invoke(null);

        Assert.assertEquals("Hello", result);
    }

}

package com.lab11;

import com.lab11.Lab11Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author Elias
 */
public class ServletInitializer extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(Lab11Application.class);
    }
    
}

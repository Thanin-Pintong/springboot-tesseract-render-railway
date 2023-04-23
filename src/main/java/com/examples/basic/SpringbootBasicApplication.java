package com.examples.basic;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * To enable it run as WebApp, then you must extends
 * SpringBootServletInitializer
 */
@SpringBootApplication
public class SpringbootBasicApplication extends SpringBootServletInitializer {

    /**
     * Used in case of .war deployment that can run both in a container and from
     * java -jar xxx.jar
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootBasicApplication.class);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        SpringApplication.run(SpringbootBasicApplication.class, args);
    }

}

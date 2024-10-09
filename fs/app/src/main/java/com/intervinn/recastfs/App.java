package com.intervinn.recastfs;

import java.io.IOException;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class App {
    Logger logger = Logger.getLogger(this.getClass().getName());

    public String getGreeting() {
        return "hello, world";
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
        app.run(args);
    }  
}

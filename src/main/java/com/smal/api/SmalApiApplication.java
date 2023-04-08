package com.smal.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smal.api.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;

@SpringBootApplication
public class SmalApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SmalApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

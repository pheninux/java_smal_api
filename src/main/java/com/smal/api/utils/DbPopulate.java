package com.smal.api.utils;


import com.smal.api.model.Event;
import com.smal.api.service.EventRepository;
import com.smal.api.service.EventRepositoryImpl;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.engine.spi.EntityEntryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

@Component
public class DbPopulate {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ResourceLoader resourceLoader;


    public static final Logger LOGGER = LoggerFactory.getLogger(DbPopulate.class.getName());

    @EventListener(ApplicationReadyEvent.class)
    public void populate() throws IOException {
        try {
            new JsonWrapper().getEventsFromJsonFile(resourceLoader).forEach(e -> {
                eventRepository.save(e);
            });
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
    }

}

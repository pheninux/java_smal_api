package com.smal.api.utils;


import com.smal.api.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

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

package com.smal.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smal.api.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class JsonWrapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonWrapper.class.getName());

    public List<Event> getEventsFromJsonFile(ResourceLoader resourceLoader) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = resourceLoader.getResource("classpath:events.json");
        Event[] events = objectMapper.readValue(resource.getFile(), Event[].class);
        return Arrays.stream(events).toList();
    }

}

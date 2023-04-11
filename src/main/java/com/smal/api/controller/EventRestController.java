package com.smal.api.controller;

import com.smal.api.model.Event;
import com.smal.api.model.dto.EventDto;
import com.smal.api.model.records.EventRecord;
import com.smal.api.repository.EventRepository;
import com.smal.api.service.EventService;
import com.smal.api.service.mapper.EventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EventRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(EventRestController.class.getName());

    @Autowired
    EventService eventService;


    @RequestMapping(value = "/v1/events", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventDto>> getAllEventDto() {
        return new ResponseEntity<>(eventService.getAllEventDto(), HttpStatus.OK);
    }

    @RequestMapping(value = "/v2/events", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventRecord>> getAllEventRecord() {
        return new ResponseEntity<>(eventService.getAllEventRecord(), HttpStatus.OK);
    }

    @RequestMapping(value = "/v1/event/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDto> create(@Validated @RequestBody EventDto event) {
        LOGGER.info("event => {}", event);
        return new ResponseEntity<>(eventService.create(event),HttpStatus.OK);
    }

}

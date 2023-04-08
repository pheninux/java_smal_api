package com.smal.api.controller;

import com.smal.api.model.Event;
import com.smal.api.service.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class EventRestController {

    @Autowired
    EventRepository eventRepository;

    @RequestMapping(value = "/events", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }


}

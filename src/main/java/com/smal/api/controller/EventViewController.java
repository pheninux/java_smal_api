package com.smal.api.controller;

import com.smal.api.model.Event;
import com.smal.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@RequestMapping
public class EventViewController {

    @Autowired
    EventRepository eventRepository;

    @RequestMapping(value = "/home")
    public ModelAndView home() {

        List<Event> events = eventRepository.findAll();
        return new ModelAndView("home", "events", events);

    }


}

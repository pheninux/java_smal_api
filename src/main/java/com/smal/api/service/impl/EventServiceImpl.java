package com.smal.api.service.impl;

import com.smal.api.model.Event;
import com.smal.api.model.dto.EventDto;
import com.smal.api.model.records.EventRecord;
import com.smal.api.repository.EventRepository;
import com.smal.api.service.EventService;
import com.smal.api.service.mapper.impl.EventMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl extends EventMapperImpl implements EventService {
    @Autowired
    EventRepository eventRepository;

    @Override
    public EventDto create(EventDto eventDto) {
        Event event = dtoToEvent(eventDto);
        return eventToDto(eventRepository.save(event));
    }

    @Override
    public List<EventDto> getAllEventDto() {
        return eventsToDtos(eventRepository.findAll());
    }

    @Override
    public List<EventRecord> getAllEventRecord() {
        return eventsToRecords(eventRepository.findAll());
    }


}

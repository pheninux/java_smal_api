package com.smal.api.service.mapper.impl;

import com.smal.api.model.Event;
import com.smal.api.model.dto.EventDto;
import com.smal.api.model.records.EventRecord;
import com.smal.api.service.mapper.EventMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventMapperImpl implements EventMapper {

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<EventDto> eventsToDtos(List<Event> events) {
        Type listType = new TypeToken<List<EventDto>>() {
        }.getType();
        List<EventDto> eventDtos = modelMapper.map(events, listType);
        return eventDtos;
    }

    @Override
    public List<EventRecord> eventsToRecords(List<Event> events) {
        return events.stream().map(this::eventToRecord).collect(Collectors.toList());
    }

    @Override
    public EventRecord eventToRecord(Event event) {
        return new EventRecord(event.getDate(), event.getContext());
    }

    @Override
    public Event dtoToEvent(EventDto eventDto) {
        return modelMapper.map(eventDto, Event.class);
    }

    @Override
    public EventDto eventToDto(Event event) {
        return modelMapper.map(event, EventDto.class);
    }


}

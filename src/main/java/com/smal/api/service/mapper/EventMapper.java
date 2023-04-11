package com.smal.api.service.mapper;

import com.smal.api.model.Event;
import com.smal.api.model.dto.EventDto;
import com.smal.api.model.records.EventRecord;

import java.util.List;
import java.util.Optional;

public interface EventMapper {
    List<EventDto> eventsToDtos(List<Event> events) ;

    List<EventRecord> eventsToRecords(List<Event> events) ;

    EventRecord eventToRecord(Event event) ;

    Event dtoToEvent (EventDto eventDto);
    EventDto eventToDto (Event event);
}

package com.smal.api.service;

import com.smal.api.model.dto.EventDto;
import com.smal.api.model.records.EventRecord;

import java.util.List;

public interface EventService {

    EventDto create (EventDto eventDto);

    List<EventDto> getAllEventDto() ;

    List<EventRecord> getAllEventRecord();
}

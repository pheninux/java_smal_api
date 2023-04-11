package com.smal.api.repository;

import com.smal.api.model.Event;
import com.smal.api.model.records.EventRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {



}

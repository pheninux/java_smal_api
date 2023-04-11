package com.smal.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.smal.api.model.Event} entity
 */
@Data
public class EventDto implements Serializable {
    private Long id;
    private String date;
    private String context;

}
package me.brimon.cloud.miniarch.miniservice.calendar.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Calendar {
    @EmbeddedId
    @JsonUnwrapped
    private CalendarId calendarId;
    private String available;
    private String price;
    private String adjustedPrice;
    private Integer minimumNights;
    private Integer maximumNights;
}

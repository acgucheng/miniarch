package me.brimon.cloud.miniarch.miniservice.calendar.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class CalendarId implements Serializable {
    private Integer listingId;
    private String date;

    public CalendarId(Integer listingId, String date) {
        this.listingId = listingId;
        this.date = date;
    }

    public CalendarId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarId that = (CalendarId) o;
        return Objects.equals(listingId, that.listingId) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listingId, date);
    }

    @Override
    public String toString() {
        return "CalendarId{" +
                "listingId=" + listingId +
                ", date='" + date + '\'' +
                '}';
    }
}

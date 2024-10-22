package me.brimon.cloud.miniarch.miniservice.listing.client;

import me.brimon.cloud.miniarch.miniservice.listing.dto.calendar.BatchAddCalendarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "calendar-service", url = "${my.config.nextService}")
public interface CalendarClient {

    @PostMapping("/calendar/{listingId}/add_calendar")
    public void createCalendars(@PathVariable Integer listingId,@RequestBody BatchAddCalendarDTO batchAddCalendarDTO);
}

package me.brimon.cloud.miniarch.miniservice.calendar.application;

import me.brimon.cloud.miniarch.miniservice.calendar.dto.BatchAddCalendarDTO;
import me.brimon.cloud.miniarch.miniservice.calendar.entity.Calendar;
import me.brimon.cloud.miniarch.miniservice.calendar.repository.CalendarRepository;
import me.brimon.cloud.miniarch.miniservice.calendar.translator.CalendarDTOTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarApplicationService {

    CalendarRepository calendarRepository;

    CalendarDTOTranslator calendarDTOTranslator;

    @Autowired
    CalendarApplicationService(CalendarRepository calendarRepository, CalendarDTOTranslator calendarDTOTranslator) {
        this.calendarRepository = calendarRepository;
        this.calendarDTOTranslator = calendarDTOTranslator;
    }

    @PostMapping("/{listingId}/add_calendar")
    public List<Calendar> addCalendar(@PathVariable Integer listingId, @RequestBody BatchAddCalendarDTO batchAddCalendarDTO) {
        List<Calendar> calendars = calendarDTOTranslator.translateBatchAddCalendarDTO(batchAddCalendarDTO);
        calendars = calendarRepository.saveAll(calendars);
        return calendars;
    }

}

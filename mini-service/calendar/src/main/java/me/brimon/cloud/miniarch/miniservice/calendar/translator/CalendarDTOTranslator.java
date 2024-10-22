package me.brimon.cloud.miniarch.miniservice.calendar.translator;

import me.brimon.cloud.miniarch.miniservice.calendar.dto.BatchAddCalendarDTO;
import me.brimon.cloud.miniarch.miniservice.calendar.entity.Calendar;
import me.brimon.cloud.miniarch.miniservice.calendar.entity.CalendarId;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CalendarDTOTranslator {

    public List<Calendar> translateBatchAddCalendarDTO(BatchAddCalendarDTO calendarDTO) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Calendar> calendars = new ArrayList<Calendar>();
        for (Date date = calendarDTO.startDate(); date.before(calendarDTO.endDate()); date.setTime(date.getTime() + 86400000)) {
            Calendar calendar = new Calendar();
            CalendarId calendarId = new CalendarId(calendarDTO.listingId(), dateFormat.format(date));
            calendar.setCalendarId(calendarId);
            calendar.setAvailable(calendarDTO.available());
            calendar.setPrice(calendarDTO.price());
            calendar.setAdjustedPrice(calendarDTO.adjustedPrice());
            calendar.setMinimumNights(calendarDTO.minimumNights());
            calendar.setMaximumNights(calendarDTO.maximumNights());
            calendars.add(calendar);
        }
        return calendars;
    }
}

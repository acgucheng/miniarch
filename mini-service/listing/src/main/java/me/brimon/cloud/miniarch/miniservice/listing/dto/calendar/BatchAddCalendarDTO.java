package me.brimon.cloud.miniarch.miniservice.listing.dto.calendar;

import lombok.Data;

import java.util.Date;

public record BatchAddCalendarDTO(
        Integer listingId,
        Date startDate,
        Date endDate,
        String available,
        String price,
        String adjustedPrice,
        Integer minimumNights,
        Integer maximumNights
) {
}

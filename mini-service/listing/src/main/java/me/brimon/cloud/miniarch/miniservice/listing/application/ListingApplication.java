package me.brimon.cloud.miniarch.miniservice.listing.application;

import me.brimon.cloud.miniarch.miniservice.listing.client.CalendarClient;
import me.brimon.cloud.miniarch.miniservice.listing.dto.calendar.BatchAddCalendarDTO;
import me.brimon.cloud.miniarch.miniservice.listing.entity.Listing;
import me.brimon.cloud.miniarch.miniservice.listing.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/listing")
public class ListingApplication {

    ListingRepository listingRepository;

    CalendarClient calendarClient;

    @Autowired
    ListingApplication(ListingRepository listingRepository, CalendarClient calendarClient) {
        this.listingRepository = listingRepository;
        this.calendarClient = calendarClient;
    }

    @GetMapping("/{id}")
    public Listing getListing(@PathVariable Integer id) {
        return listingRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public void createListing(@RequestBody Listing listing){
        listingRepository.save(listing);
        Calendar calendar = Calendar.getInstance();
        Date today = new Date();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, 30);
        Date endDate = calendar.getTime();
        BatchAddCalendarDTO batchAddCalendarDTO = new BatchAddCalendarDTO(
                listing.getId(),
                today,
                endDate,
                "t",
                listing.getPrice(),
                null,
                listing.getMinimumNights(),
                365
        );
        calendarClient.createCalendars(listing.getId(), batchAddCalendarDTO);
    }

    @PutMapping("/{id}")
    public void updateListing(@PathVariable Integer id, @RequestBody Listing listing) {
        listingRepository.findById(id);
        listingRepository.save(listing);
    }

    @DeleteMapping("/{id}")
    public void deleteListing(@RequestParam Integer id) {
        listingRepository.deleteById(id);
    }


}

package me.brimon.cloud.miniarch.miniservice.listing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Listing {
    @Id
    private Integer id;
    private String name;
    private Integer hostId;
    private String hostName;
    private String neighbourhoodGroup;
    private String neighbourhood;
    private Double latitude;
    private Double longitude;
    private String roomType;
    private String price;
    private Integer minimumNights;
    private Integer numberOfReviews;
    private String lastReview;
    private Double reviewsPerMonth;
    private Integer calculatedHostListingsCount;
    private Integer availability365;
    private String numberOfReviewsLtm;
    private String license;
}

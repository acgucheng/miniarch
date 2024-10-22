package me.brimon.cloud.miniarch.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class ListingDTO {
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

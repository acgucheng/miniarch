package me.brimon.cloud.miniarch.application;

import me.brimon.cloud.miniarch.client.ListingClient;
import me.brimon.cloud.miniarch.dto.ListingDTO;
import me.brimon.cloud.miniarch.entity.Review;
import me.brimon.cloud.miniarch.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewApplication {

    ReviewRepository reviewRepository;

    ListingClient listingClient;
    @Autowired
    ReviewApplication(ReviewRepository reviewRepository, ListingClient listingClient) {
        this.reviewRepository = reviewRepository;
        this.listingClient = listingClient;
    }

    @GetMapping("/{id}")
    public Review getReview(@PathVariable Integer id) {
        return reviewRepository.findById(id).get();
    }

    @PostMapping("")
    public void createReview(@RequestBody Review review){
        Integer id = review.getListingId();
        reviewRepository.save(review);
        ListingDTO listingDTO = listingClient.getListing(id);
        if(listingDTO == null) {
            return;
        }
        listingDTO.setNumberOfReviews(listingDTO.getNumberOfReviews() + 1);
        listingClient.updateListing(listingDTO);
    }

    @PutMapping("/{id}")
    public void updateReview(@PathVariable Integer id, @RequestBody Review review) {
        reviewRepository.findById(id);
        reviewRepository.save(review);
    }

}

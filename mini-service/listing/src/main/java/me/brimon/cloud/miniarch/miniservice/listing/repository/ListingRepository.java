package me.brimon.cloud.miniarch.miniservice.listing.repository;

import me.brimon.cloud.miniarch.miniservice.listing.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Integer> {
    public Listing save(Listing listing);
    public Optional<Listing> findById(Integer id);
}

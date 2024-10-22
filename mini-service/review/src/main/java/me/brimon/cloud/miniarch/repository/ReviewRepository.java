package me.brimon.cloud.miniarch.repository;

import me.brimon.cloud.miniarch.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
    public Review save(Review review);
    public Optional<Review> findById(Integer id);
}

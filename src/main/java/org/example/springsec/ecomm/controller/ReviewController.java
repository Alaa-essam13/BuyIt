package org.example.springsec.ecomm.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.dto.ReviewDto;
import org.example.springsec.ecomm.entity.Review;
import org.example.springsec.ecomm.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{p_id}")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long p_id) {
       return reviewService.getAllReviewsOfProductById(p_id);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }
}

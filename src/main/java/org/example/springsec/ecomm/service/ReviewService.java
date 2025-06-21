package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.dto.ReviewDto;
import org.example.springsec.ecomm.entity.Product;
import org.example.springsec.ecomm.entity.Review;
import org.example.springsec.ecomm.entity.User;
import org.example.springsec.ecomm.repo.ReviewRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepo reviewRepo;
    private final UserService userService;
    private final ProductService productService;

    public ResponseEntity<Void> addReview(ReviewDto review) {
        User u = userService.getUserById(review.getU_id());
        Product p = productService.getProduct(review.getP_id());

        reviewRepo.save(Review.builder()
                .rating(review.getRating())
                .comment(review.getComment())
                .createdAt(LocalDateTime.now())
                .user(u)
                .product(p)
                .build()
        );
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<Review>> getAllReviewsOfProductById(Long id) {
        return ResponseEntity.ok(reviewRepo.findByProductId(id));
    }


}

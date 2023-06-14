package cafe.review.web.controller.review;


import cafe.review.domain.Review;
import cafe.review.service.review.ReviewServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewController {
    private ReviewServiceInterface reviewServiceInterface;


    @GetMapping("/review_list")
    public String reviewlistForm(Model model){
        List<Review> review = reviewServiceInterface.findAll();
        model.addAttribute("review", new Review());
        return "review/review_list";
    }



}

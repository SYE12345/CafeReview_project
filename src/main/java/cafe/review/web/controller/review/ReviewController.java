package cafe.review.web.controller.review;


import cafe.review.domain.CafeMember;
import cafe.review.domain.Review;
import cafe.review.service.review.ReviewServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewServiceInterface reviewServiceInterface;


    // 리뷰 전체페이지
    @GetMapping("/review_list")
    public String reviewListForm(Model model) {
        List<Review> review = reviewServiceInterface.findAll();
        model.addAttribute("reviews", review);
        return "review/review_list";
    }

    // 리뷰쓰기
    @GetMapping("/review")
    public String reviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "review/review";
    }

    @PostMapping("/review")
    public String review(@ModelAttribute Review review, RedirectAttributes redirectAttributes) {
        Review savedReview = reviewServiceInterface.save(review);
        redirectAttributes.addAttribute("reviewTitle", savedReview.getReviewTitle());
        redirectAttributes.addAttribute("reviewContent", savedReview.getReviewContent());
        return "redirect:/review_list";
    }

    // 카페 리뷰 검색
    @PostMapping("/searchByReviewTitle")
    public String searchByCafeName(@RequestParam("reviewTitle") String reviewTitle, Model model) {
        List<Review> result = reviewServiceInterface.searchByReviewTitle(reviewTitle);
        model.addAttribute("reviews", result);
        return "review/review_list";


    }
}
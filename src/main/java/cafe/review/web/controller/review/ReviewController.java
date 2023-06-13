package cafe.review.web.controller.review;


import cafe.review.domain.Review;
import cafe.review.service.review.ReviewServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ReviewController {
    private ReviewServiceInterface reviewServiceInterface;


    @GetMapping("/review_list")
    public String reviewForm(Model model){
        model.addAttribute("review", new Review());
        return "review/review_list";
    }


}

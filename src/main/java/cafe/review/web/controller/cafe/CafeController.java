package cafe.review.web.controller.cafe;

import cafe.review.domain.cafe.Cafe;
import cafe.review.domain.cafe.CafeMember;
import cafe.review.repository.cafe.CafeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("cafe/All_list")
@RequiredArgsConstructor
public class CafeController {
    private final CafeRepository cafeRepository;

    @GetMapping
    public String All_list(Model model){
        List<CafeMember> cafeMembers = CafeRepository.findAll();
        model.addAttribute("cafe",cafeMembers);
        return "cafe/All_list";
    }

}

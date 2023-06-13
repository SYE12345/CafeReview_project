package cafe.review.web.controller.cafe;

import cafe.review.domain.cafe.CafeMember;
import cafe.review.service.cafe.CafeMemberServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CafeController {
    private final CafeMemberServiceInterface cafeMemberServiceInterface;


    @GetMapping("All_list")
    public String All_list(Model model){
        List<CafeMember> cafeMembers = cafeMemberServiceInterface.findAll();
        model.addAttribute("cafes", cafeMembers);
        return "cafe/All_list";
    }

    @GetMapping("All_list/{cafeName}")
    public String deailsForm(@PathVariable String cafeName, Model model){
        CafeMember cafeMember = cafeMemberServiceInterface.findByCafeName(cafeName).get();
        model.addAttribute("cafes",cafeMember);
        return "cafe/details";
    }

}

package cafe.review.web.controller.cafe;


import cafe.review.domain.CafeMember;
import cafe.review.service.cafe.CafeMemberServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CafeController {

    private final CafeMemberServiceInterface cafeMemberServiceInterface;


    @GetMapping("/All_list")
    public String All_list(Model model){
        List<CafeMember> cafeMembers = cafeMemberServiceInterface.findAll();
        model.addAttribute("cafes", cafeMembers);
        return "cafe/All_list";
    }

    @GetMapping("/All_list/{cafeName}")
    public String detailsForm(@PathVariable String cafeName, Model model){
        CafeMember cafeMember = cafeMemberServiceInterface.findByCafeName(cafeName).get();
        model.addAttribute("cafes",cafeMember);
        return "cafe/details";
    }

    @GetMapping("/findByFran")
    public String findByFran(Model model){
        List<CafeMember> cafetypes = cafeMemberServiceInterface.findByFran();
        model.addAttribute("cafes", cafetypes);
        return "cafe/findByFran";
    }

    @GetMapping("/findByGam")
    public String findByGam(Model model){
        List<CafeMember> cafetypes2 = cafeMemberServiceInterface.findByGam();
        model.addAttribute("cafes", cafetypes2);
        return "cafe/findByGam";
    }
}


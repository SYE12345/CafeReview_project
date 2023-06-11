package cafe.review.web.controller.member;

import cafe.review.domain.Member;
import cafe.review.service.MemberServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiceInterface memberServiceInterface;

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("member", new Member());
        return "member/join";
    }

    @PostMapping("/join")
    public String join(Member member) {
        memberServiceInterface.save(member);
        return "redirect:/";
    }
}

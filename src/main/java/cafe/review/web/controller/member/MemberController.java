package cafe.review.web.controller.member;

import cafe.review.domain.Member;
import cafe.review.repository.MemberInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private MemberInterface memberInterface;

    @GetMapping("/join")
    public String joinForm(Member member) {
        return "member/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute Member member) {
        memberInterface.save(member);
        return "redirect:/main/main";
    }
}

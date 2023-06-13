package cafe.review.web.controller.member;

import cafe.review.domain.Member;
import cafe.review.repository.MemberUpdateDto;
import cafe.review.service.MemberServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j
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

    @GetMapping("/{loginId}/myInfo")
    public String myInfoForm(@PathVariable String loginId, Model model) {
        Member member = memberServiceInterface.findByLoginId(loginId).get();
        model.addAttribute("member",member);
        return "member/myInfo";
    }

    @PostMapping("/{loginId}/myInfo")
    public String myInfo(@PathVariable String loginId, MemberUpdateDto member) {
        memberServiceInterface.update(loginId, member);

        return "redirect:/";
    }



}

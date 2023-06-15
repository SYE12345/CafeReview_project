package cafe.review.web.controller.member;

import cafe.review.domain.Member;
import cafe.review.repository.member.MemberUpdateDto;
import cafe.review.service.member.MemberServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

//    @PostMapping("/join")
//    public String join(Member member) {
//        memberServiceInterface.save(member);
//        return "redirect:/";
//    }

    @PostMapping("/join")
    public String join(@Validated @ModelAttribute
                       Member member, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        Member savedMember = memberServiceInterface.save(member);
        if (savedMember == null) {
            bindingResult.rejectValue("loginId", "duplicate.loginId",
                    "해당 아이디가 이미 사용중입니다.");
        }
        if(bindingResult.hasErrors()){
            return "member/join";
        }
        redirectAttributes.addAttribute("loginId",savedMember.getLoginId());
        redirectAttributes.addAttribute("status",true);
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

package cafe.review.web.controller.home;

import cafe.review.domain.CafeMember;
import cafe.review.domain.Member;
import cafe.review.repository.SessionConst;
import cafe.review.service.cafe.CafeMemberServiceInterface;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {


    @GetMapping("/")
    public String home (HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return "main/main";
        }
        Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if (loginMember == null){
            return "main/main";
        }
        model.addAttribute("member",loginMember);
        return "main/main_login";


    }

}

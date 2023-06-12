package cafe.review.web.controller.login;

import cafe.review.domain.member.Member;
import cafe.review.repository.SessionConst;
import cafe.review.service.LoginInterface;
import cafe.review.service.MemberServiceInterface;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final MemberServiceInterface memberServiceInterface;
    private final LoginInterface loginInterface;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@Valid  @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }
        Member loginMember = loginInterface.login(form.getLoginId(), form.getPassword());

        if (loginMember == null) {
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 바르지 않습니다.");
            return "login/login";
        }

        HttpSession session = request.getSession();

        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/find_id")
    public String find_LoginId_Form(@ModelAttribute("member") findLoginIdForm form){
        return "/login/find_LoginId";
    }

    @PostMapping("/find_id")
    public String find_Loginid(@RequestParam("name") String name, @RequestParam("email") String email, Model model){
        Member result = memberServiceInterface.findByNameEmail(name, email).get();
        model.addAttribute("member", result);
        return "login";

    }




}

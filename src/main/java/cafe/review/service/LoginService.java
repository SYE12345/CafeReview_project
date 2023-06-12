package cafe.review.service;

import cafe.review.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginInterface{
    private final MemberServiceInterface memberServiceInterface;

    @Override
    public Member login(String loginId, String password) {
        return memberServiceInterface.findByLoginId(loginId)
                .filter(m->m.getPassword().equals(password))
                .orElse(null);
    }
}

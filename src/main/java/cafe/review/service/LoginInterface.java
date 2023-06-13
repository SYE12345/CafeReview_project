package cafe.review.service;

import cafe.review.domain.Member;

public interface LoginInterface {
    Member login (String loginId, String password);
}

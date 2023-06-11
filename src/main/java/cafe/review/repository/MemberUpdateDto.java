package cafe.review.repository;

import lombok.Data;

@Data
public class MemberUpdateDto {
    private String password;
    private String email;
    private String phoneNumber;

    public MemberUpdateDto(){
    }

    public MemberUpdateDto(String password, String email, String phoneNumber) {
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

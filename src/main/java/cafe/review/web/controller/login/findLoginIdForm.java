package cafe.review.web.controller.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class findLoginIdForm {

    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
}

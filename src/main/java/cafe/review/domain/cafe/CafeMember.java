package cafe.review.domain.cafe;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CafeMember {
    private Long cafeId;
    private String cafeName;
    private String address; //주소
    private String number;

    private String menu1;
    private String menu2;
    private String menu3;
    public CafeMember(Long cafeId, String cafeName, String address, String number, String menu1, String menu2, String menu3) {
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.address = address;
        this.number = number;
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;
    }

}

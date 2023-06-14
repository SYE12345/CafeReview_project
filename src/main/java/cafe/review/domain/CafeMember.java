package cafe.review.domain;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CafeMember {
    private Long cafeId;
    private String cafeName;
    private String address; //주소
    private String cafeNumber;
    private String menu1;
    private String menu2;
    private String menu3;
    private String cafeType;   //종류

    public CafeMember(){
    }

    public CafeMember(String cafeName, String address, String cafeNumber, String menu1, String menu2, String menu3, String cafeType) {
        this.cafeName = cafeName;
        this.address = address;
        this.cafeNumber = cafeNumber;
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;
        this.cafeType = cafeType;
    }
}

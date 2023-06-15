package cafe.review.repository.cafe;

import lombok.Data;

@Data
public class cafeNameSearchCond {

    private String cafeName;

    public cafeNameSearchCond(){}

    public cafeNameSearchCond(String cafeName) {
        this.cafeName = cafeName;
    }
}

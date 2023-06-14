package cafe.review.repository;

import lombok.Data;

@Data
public class cafeNameSearchCond {

    private String cafeName;

    public cafeNameSearchCond(String cafeName) {
        this.cafeName = cafeName;
    }
}

package be.knoware.atlas.domain.party;


/**
 * Created by ovanekem on 22/12/15.
 */
public class Organization extends Party {
    private String bceNumber;

    public Organization() {
    }

    public String getBceNumber() {
        return bceNumber;
    }

    public void setBceNumber(String bceNumber) {
        this.bceNumber = bceNumber;
    }
}

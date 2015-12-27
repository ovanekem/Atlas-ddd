package be.knoware.atlas.domain.party;

/**
 * Created by ovanekem on 23/12/15.
 */
public class Address {

    private Integer id;


    private String street;
    private String houseNumber;
    private String zip;
    private String city;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

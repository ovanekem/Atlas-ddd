package be.knoware.atlas.domain.party;

/**
 * Created by ovanekem on 22/12/15.
 */
public class Individual extends Party {
    private String firstName;
    private String lastName;
    private String profession;
    private boolean isDead;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public Individual() {

    }
}

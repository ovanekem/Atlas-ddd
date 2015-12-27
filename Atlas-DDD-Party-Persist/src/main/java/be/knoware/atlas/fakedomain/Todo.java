package be.knoware.atlas.fakedomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ovanekem on 26/12/15.
 */
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public Todo() {

    }
}

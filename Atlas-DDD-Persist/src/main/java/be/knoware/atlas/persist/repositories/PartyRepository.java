package be.knoware.atlas.persist.repositories;

import be.knoware.atlas.domain.party.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ovanekem on 23/12/15.
 */
public interface PartyRepository extends JpaRepository<Party, Integer> {
    public List<Party> findByDenomination(String denomination);

}

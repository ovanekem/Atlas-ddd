package be.knoware.atlas.service;

import be.knoware.atlas.domain.party.Party;
import be.knoware.atlas.persist.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ovanekem on 23/12/15.
 */
@Service
public class PartyService {
    @Autowired
    private PartyRepository partyRepository;

    public List<Party>fetchAllPartyFromDatabase() {
        List<Party> parties = partyRepository.findAll();
        return parties;
    }

    public void addParty(Party party) {
        partyRepository.save(party);

    }
}

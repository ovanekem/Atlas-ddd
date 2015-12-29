package be.knoware.atlas.service;

import be.knoware.atlas.domain.communication.CommunicationPoint;
import be.knoware.atlas.domain.party.Party;
import be.knoware.atlas.persist.repositories.CommunicationRepository;
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

    @Autowired
    private CommunicationRepository communicationRepository;

    public List<Party>fetchAllPartiesFromDatabase() {
        List<Party> parties = partyRepository.findAll();
        for (Party party : parties) {
            List<CommunicationPoint> points = communicationRepository.findByPartyId(party.getId());
            party.setCommunicationPointList(points);
        }
        return parties;
    }

    public void addParty(Party party) {
        partyRepository.save(party);

    }
}

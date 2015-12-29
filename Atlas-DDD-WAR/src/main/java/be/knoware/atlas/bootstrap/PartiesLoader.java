package be.knoware.atlas.bootstrap;

import be.knoware.atlas.domain.communication.Address;
import be.knoware.atlas.domain.communication.CommunicationPoint;
import be.knoware.atlas.domain.communication.Email;
import be.knoware.atlas.domain.party.Organization;
import be.knoware.atlas.domain.party.Party;
import be.knoware.atlas.persist.repositories.CommunicationRepository;
import be.knoware.atlas.persist.repositories.PartyRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ovanekem on 27/12/15.
 */
@Component
public class PartiesLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PartyRepository partyRepository;
    @Autowired
    private CommunicationRepository communicationRepository;

    public static final Logger LOGGER = Logger.getLogger(PartyRepository.class);
    private static boolean _isInitialized = false;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (!PartiesLoader._isInitialized) {
            Organization vicromis = new Organization();
            vicromis.setDenomination("Vicromis SPRL");
            vicromis.setBceNumber("BE 0842.567.833");
            String string = "01/01/2012";
            DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
            try {
                Date vicromisStartDate = format.parse(string);
                vicromis.setStartDate(vicromisStartDate);
            } catch (ParseException pe) {
                LOGGER.error("Cannot parse start date for Vicromis", pe);
            }

            partyRepository.save(vicromis);
            LOGGER.info("Vicromis entity saved with ID=" + vicromis.getId());

            Email emailVicromis = new Email();
            emailVicromis.setPartyId(vicromis.getId());
            emailVicromis.setAddress("info");
            emailVicromis.setDomain("vicromis.be");
            communicationRepository.save(emailVicromis);

            Address addressVicromis = new Address();
            addressVicromis.setCity("Wavre");
            addressVicromis.setHouseNumber("19");
            addressVicromis.setZip("1301");
            addressVicromis.setStreet("Av. du champ de courses");
            addressVicromis.setPartyId(vicromis.getId());
            communicationRepository.save(addressVicromis);

            Organization knoware = new Organization();
            knoware.setDenomination("Knoware SA");
            knoware.setBceNumber("BE 0465.344.632");
            string = "01/01/1998";
            format = new SimpleDateFormat("dd/MM/YYYY");
            try {
                Date knowareStartDate = format.parse(string);
                knoware.setStartDate(knowareStartDate);
            } catch (ParseException pe) {
                LOGGER.error("Cannot parse start date for Knoware", pe);
            }

            partyRepository.save(knoware);
            LOGGER.info("Knoware entity saved with ID=" + knoware.getId());

            Email emailKnoware = new Email();
            emailKnoware.setAddress("info");
            emailKnoware.setDomain("knoware.be");
            emailKnoware.setPartyId(knoware.getId());
            communicationRepository.save(emailKnoware);
        }
        PartiesLoader._isInitialized = true;

    }
}

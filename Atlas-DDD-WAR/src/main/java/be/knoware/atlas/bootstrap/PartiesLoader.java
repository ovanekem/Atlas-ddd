package be.knoware.atlas.bootstrap;

import be.knoware.atlas.domain.party.Party;
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

    public static final Logger LOGGER = Logger.getLogger(PartyRepository.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Party vicromis = new Party();
        vicromis.setDenomination("Vicromis SPRL");
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

        Party knoware = new Party();
        knoware.setDenomination("Knoware SA");
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
    }
}

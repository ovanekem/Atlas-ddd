package be.knoware.atlas.web;

import be.knoware.atlas.domain.party.Party;
import be.knoware.atlas.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ovanekem on 23/12/15.
 */
@RestController
public class PartyController {

    @Autowired
    private PartyService partyService;

    @RequestMapping(value = "/party/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Party> listAllParties() {

        List<Party> parties = partyService.fetchAllPartyFromDatabase();
        return parties;

    }

}

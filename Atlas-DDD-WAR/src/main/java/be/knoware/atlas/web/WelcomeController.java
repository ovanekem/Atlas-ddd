package be.knoware.atlas.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ovanekem on 26/12/15.
 */
@Controller
@RequestMapping("/welcomePage")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showWelcome() {
        ModelAndView model = new ModelAndView();
        model.setViewName("home");
        return model;
    }
}

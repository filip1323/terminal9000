package ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Filip on 2015-07-23.
 */
@Controller
@RequestMapping("/")
public class FrontController {

    @RequestMapping(value="editor", method = RequestMethod.GET)
    public String viewEditor(/*@RequestParam(value="name", required=false, defaultValue="World") String name, Model model*/) {
        System.out.println("FRONT CONTROLLER REQUEST");
        return "editor";
    }
    @RequestMapping(value="manager", method = RequestMethod.GET)
    public String viewManager(/*@RequestParam(value="name", required=false, defaultValue="World") String name, Model model*/) {
        System.out.println("FRONT CONTROLLER REQUEST");
        return "manager";
    }
}

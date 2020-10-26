package curso.springframework.sfpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerControlle {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOfOwners(){
        return "owners/index";
    }
}

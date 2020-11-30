package curso.springframework.sfpetclinic.controllers;

import curso.springframework.sfpetclinic.model.Owner;
import curso.springframework.sfpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }
//
//    @RequestMapping({"", "/", "/index", "/index.html"})
//    public String listOfOwners(Model model){
//        model.addAttribute("owners", ownerService.findAll());
//
//        return "owners/index";
//    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());

        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
        if(owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> owners = ownerService.findAllByLastNameLike(owner.getLastName());

        if(owners.isEmpty()){
            result.rejectValue("lastName","notFound","not found");
            return "owners/findOwners";
        }else if (owners.size() == 1){
            owner = owners.get(0);
            return "redirect:/owners/" + owner.getId();
        }else{
            model.addAttribute("selections" , owners);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable String ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");

        mav.addObject(ownerService.findById(Long.valueOf(ownerId)));

        return mav;
    }

    @GetMapping("/new")
    public String initCreateOwner(Model model){
        Owner owner = new Owner();

        model.addAttribute("owner",owner);

        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String createNewOwner(Owner owner,BindingResult result){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        }else{
            Owner ownerSaved = this.ownerService.save(owner);
            return "redirect:/owners/" + ownerSaved.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initEditOwner(@PathVariable String ownerId, Model model){
        Owner foundOwner = ownerService.findById(Long.valueOf(ownerId));

        model.addAttribute("owner", foundOwner);

        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String editOwner(@PathVariable String ownerId, Owner owner, Model model, BindingResult result){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        }else{
            owner.setId(Long.valueOf(ownerId));
            Owner savedOwner = ownerService.save(owner);
            model.addAttribute("owner",owner);

            return "redirect:/owners/" + savedOwner.getId();
        }
    }
}

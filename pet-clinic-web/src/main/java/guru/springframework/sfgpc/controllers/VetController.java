package guru.springframework.sfgpc.controllers;

import guru.springframework.sfgpc.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(final VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping(value = {"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(final Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }

}

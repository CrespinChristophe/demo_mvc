package technifutur.crespin.demo_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import technifutur.crespin.demo_mvc.models.Produit;
import technifutur.crespin.demo_mvc.service.ProduitService;

import java.util.NoSuchElementException;

@Controller//ce n'est pas un controller de REST API donc simplement controller
public class ProduitController {

    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping("/produit/{id}")
    public String displayOne(@PathVariable int id, Model model){

        Produit p = service.getOne(id);
        model.addAttribute("produit", p);


        return "displayOne";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handle(NoSuchElementException ex){
        return "404";
    }


}

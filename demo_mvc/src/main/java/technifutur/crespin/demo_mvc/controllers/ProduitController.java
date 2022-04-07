package technifutur.crespin.demo_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import technifutur.crespin.demo_mvc.models.Produit;
import technifutur.crespin.demo_mvc.service.ProduitService;

import java.util.List;
import java.util.NoSuchElementException;

@Controller//ce n'est pas un controller de REST API donc simplement controller
@RequestMapping("/produit")
public class ProduitController {

    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String displayOne(@PathVariable int id, Model model){

        Produit p = service.getOne(id);
        model.addAttribute("produit", p);


        return "displayOne";
    }

    @GetMapping
    public String displayAll(Model model){
        List<Produit> list = service.getAll();
        model.addAttribute("liste_produit", list);
        return "displayAll";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handle(NoSuchElementException ex){
        return "404";
    }


}

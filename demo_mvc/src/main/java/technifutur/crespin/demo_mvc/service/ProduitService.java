package technifutur.crespin.demo_mvc.service;

import org.springframework.stereotype.Service;
import technifutur.crespin.demo_mvc.models.Produit;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService {

    private final List<Produit> produits;

    public ProduitService() {

        produits = new ArrayList<>();
        produits.add((
                Produit.builder()
                        .id(1)
                        .marque("marque 1")
                        .modele("2p1")
                        .prix(5)
                        .enVente(true)
                        .build()
                ));

        produits.add((
                Produit.builder()
                        .id(2)
                        .marque("marque 2")
                        .modele("2p2")
                        .prix(5)
                        .enVente(true)
                        .build()
        ));

        produits.add((
                Produit.builder()
                        .id(3)
                        .marque("marque 3")
                        .modele("2p3")
                        .prix(5)
                        .enVente(false)
                        .build()
        ));

    }

    public Produit getOne(int id){
        return produits.stream().filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow();

    }

    public List<Produit> getAll(){
        return new ArrayList<>(produits);//on return une copie de la liste...Protection !!!!
    }


}

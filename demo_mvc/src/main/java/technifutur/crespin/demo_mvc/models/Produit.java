package technifutur.crespin.demo_mvc.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Produit {

    private int id;
    private String marque;
    private String modele;
    private double prix;
    private boolean enVente;
}

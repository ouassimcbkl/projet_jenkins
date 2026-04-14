package fr.epsi.service;

import fr.epsi.model.Article;
import fr.epsi.model.Panier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandeServiceIT {

    private final CommandeService service = new CommandeService();

    @Test
    void pipelineComplete() {
        Panier panier = new Panier();
        panier.ajouter(new Article("Stylo", 2.0), 10);
        panier.ajouter(new Article("Cahier", 5.0), 2);

        double total = service.calculerTotal(panier);
        double remise = service.appliquerRemise(total, 10);
        String categorie = service.categoriserCommande(remise);

        assertEquals("PETITE", categorie);
    }
}
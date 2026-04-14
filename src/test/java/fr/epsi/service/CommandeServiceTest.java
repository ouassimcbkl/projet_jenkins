package fr.epsi.service;

import fr.epsi.model.Article;
import fr.epsi.model.Panier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class CommandeServiceTest {

    private final CommandeService service = new CommandeService();

    @Test
    @DisplayName("Total correct pour 3 articles à 2€")
    void calculerTotal_3Articles_Retourne6() {
        // GIVEN
        Panier panier = new Panier();
        panier.ajouter(new Article("Stylo", 2.0), 3);

        // WHEN
        double total = service.calculerTotal(panier);

        // THEN
        assertEquals(6.0, total, 0.001);
    }

    @Test
    void calculerTotal_panierVide_exception() {
        Panier panier = new Panier();

        assertThrows(IllegalArgumentException.class, () -> {
            service.calculerTotal(panier);
        });
    }

    @Test
    void appliquerRemise_10pourcent() {
        double resultat = service.appliquerRemise(100, 10);

        assertEquals(90.0, resultat, 0.001);
    }

    @Test
    void appliquerRemise_invalide() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.appliquerRemise(100, 150);
        });
    }

    @Test
    void categoriserCommande_petitte() {
        String cat = service.categoriserCommande(30);

        assertEquals("PETITE", cat);
    }
}
package org.centrale;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreation() {
        Joueur joueur1 = new Joueur(Couleur.BLANC, "Alfred");
        Joueur joueur2 = new Joueur(Couleur.NOIR, "Bernard");
        assertEquals(joueur1.toString(), "Alfred joue les pions blancs");
        assertEquals(joueur2.toString(), "Bernard joue les pions noirs");

    }

    @Test
    void testModifications() {
        Joueur joueur1 = new Joueur(Couleur.BLANC, "Alfred");
        Joueur joueur2 = new Joueur(Couleur.NOIR, "Bernard");
        joueur1.setCouleur(Couleur.NOIR);
        joueur1.setCouleur(Couleur.BLANC);
        assertEquals(joueur1.toString(), "Alfred joue les pions noirs");
        assertEquals(joueur2.toString(), "Bernard joue les pions blancs");

        joueur1.setNom("A");
        joueur1.setNom("B");
        assertEquals(joueur1.toString(), "A joue les pions noirs");
        assertEquals(joueur2.toString(), "B joue les pions blancs");

    }
}
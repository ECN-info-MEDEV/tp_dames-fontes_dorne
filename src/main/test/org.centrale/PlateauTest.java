package org.centrale;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class PlateauTest {

    //TODO Contourner input utilisateur
    void testInitPassant() {
        //Arrange
        Plateau plateau = new Plateau();
        String plateauToString = """
                   1 2 3 4 5 6 7 8 9 10
                1  x| |x| |x| |x| |x|\s
                2   |x| |x| |x| |x| |\s
                3  x| |x| |x| |x| |x|\s
                4   |x| |x| |x| |x| |\s
                5   | | | | | | | | |\s
                6   | | | | | | | | |\s
                7   |o| |o| |o| |o| |\s
                8  o| |o| |o| |o| |o|\s
                9   |o| |o| |o| |o| |\s
                10 o| |o| |o| |o| |o|\s
                """;

        //Act

        //Assert
        assertEquals(2, plateau.getJoueurs().size());
        assertEquals(20, plateau.getPions().size());
        assertEquals(plateauToString, plateau.toString());
    }

    @Test
    void testTourDeJeuPassant() {
    }

    @Test
    void testTourDeJeuNonPassant() {
    }

    @Test
    void testIsGameFinishedPassant() {
    }

    @Test
    void testIsGameFinishedNonPassant() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testVerifDeplacement() {
        //Arrange
       Plateau plateau = new Plateau();
       ArrayList<Pion> pions = new ArrayList<>();
       Pion pion1 = new Pion(new Point2D(2,2), Couleur.BLANC);
       Pion pion2 = new Pion(new Point2D(3,3), Couleur.BLANC);
       pions.add(pion1);
       pions.add(pion2);
       plateau.setPions(pions);
       //Assert
       assertFalse(plateau.verifDeplacement(new Point2D(2,4), new Point2D(3,4))); //Pas en diagonal
       assertFalse(plateau.verifDeplacement(new Point2D(2,4), new Point2D(8,8))); // Trop long
       assertFalse(plateau.verifDeplacement(new Point2D(0,0), new Point2D(-1,-1))); // Hors du plateau
       assertFalse(plateau.verifDeplacement(new Point2D(2,2), new Point2D(3,3))); // Place occupee
       
       assertTrue(plateau.verifDeplacement(new Point2D(2,2), new Point2D(1,3)));
       assertTrue(plateau.verifDeplacement(new Point2D(2,2), new Point2D(1,1)));
    }
}

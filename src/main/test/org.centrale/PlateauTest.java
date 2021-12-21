package org.centrale;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class PlateauTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testInit() {
    }

    @Test
    void testTourDeJeu() {
    }

    @Test
    void testIsGameFinished() {
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
       assertFalse(plateau.verifDeplacement(new Point2D(2,2), new Point2D(3,3))); // Place occupée
       
       assertTrue(plateau.verifDeplacement(new Point2D(2,2), new Point2D(1,3)));
       assertTrue(plateau.verifDeplacement(new Point2D(2,2), new Point2D(1,1)));
    }
}

package org.centrale;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlateauTest {

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void testInit() {
    }

    @Test
    public void testTourDeJeu() {
    }

    @Test
    public void testIsGameFinished() {
    }

    @Test
    public void testDeplacePion() {
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

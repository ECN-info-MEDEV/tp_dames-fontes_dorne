package org.centrale;

import java.util.List;
import java.util.Scanner;

/**
 * Main class
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //Initialisation du plateau de jeu
        Plateau plateau = new Plateau();
        plateau.init();

//        while (!isGameFinished(plateau)) {
//            tourDeJeu(plateau);
//        }

    }
}

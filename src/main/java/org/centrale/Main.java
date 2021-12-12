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
        Plateau plateau = init();

    }

    public static Plateau init(){

        Plateau plateau = new Plateau();
        List<Pion> pions = plateau.getPions();

        //Création des Pions
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {

                if ( i == 5 || i == 6) {
                    //Pas de pions sur les lignes 5 et 6
                } else if (i % 2 == 0) {
                    //Si ligne paire alors pions sur colonne paire
                    if (j % 2 == 0) {
                        if (i <= 5) {
                            pions.add(new Pion(new Point2D(i, j), Couleur.BLANC));
                        } else {
                            pions.add(new Pion(new Point2D(i, j), Couleur.NOIR));
                        }
                    }
                } else {
                    //Sinon ajout pions sur colonne impaire
                    if (j % 2 == 1) {
                        if (i <= 5) {
                            pions.add(new Pion(new Point2D(i, j), Couleur.BLANC));
                        } else {
                            pions.add(new Pion(new Point2D(i, j), Couleur.NOIR));
                        }
                    }
                }
            }
        }

        //Création des Joueurs
        Scanner myObj = new Scanner(System.in);

        System.out.println("Quel est le nom du joueur 1 ?");
        String nom1 = myObj.nextLine();
        plateau.getJoueurs().add(new Joueur(Couleur.BLANC, nom1));
        System.out.println(plateau.getJoueurs().get(0).toString());

        System.out.println("Quel est le nom du joueur 2 ?");
        String nom2 = myObj.nextLine();
        plateau.getJoueurs().add(new Joueur(Couleur.NOIR, nom2));
        System.out.println(plateau.getJoueurs().get(1).toString());

        //Fin de l'initialisation du jeu
        System.out.println("Jouons au jeu de Dames !\n");

        System.out.println(plateau);

        return plateau;
    }
}

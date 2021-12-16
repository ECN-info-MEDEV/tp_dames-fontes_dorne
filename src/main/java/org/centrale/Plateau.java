package org.centrale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Plateau
 */
public class Plateau {

    private List<Pion> pions;

    private List<Joueur> joueurs;


    /**
     * Constructeur vide
     */
    public Plateau() {
        this.pions = new ArrayList<>();
        this.joueurs = new ArrayList<>();
    }

    /**
     * Constructeur
     *
     * @param pions   the pions
     * @param joueurs the joueurs
     */
    public Plateau(List<Pion> pions, List<Joueur> joueurs) {
        this.pions = pions;
        this.joueurs = joueurs;
    }


    public Plateau init(){

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

    public void tourDeJeu(Plateau plateau) {
    }

    public boolean isGameFinished(Plateau plateau) {

        Boolean test = false;

        //Test sur fin de partie


        if (test) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String visu = """
                 | | | | | | | | |\s
                 | | | | | | | | |\s
                 | | | | | | | | |\s
                 | | | | | | | | |\s
                 | | | | | | | | |\s
                 | | | | | | | | |\s
                 | | | | | | | | |\s
                 | | | | | | | | |\s
                 | | | | | | | | |\s
                 | | | | | | | | |\s
                """;

        int position;
        for (Pion pion : pions) {
            position = (pion.getPosition().getX() - 1) * 20 + (pion.getPosition().getY() - 1) * 2;
            visu = visu.substring(0,position) + pion + visu.substring(position + 1);
        }
        return "\t" + this.getJoueurs().get(0).getNom() + "\n" + visu + "\t" + this.getJoueurs().get(1).getNom();
    }


    /**
     * Gets pions.
     *
     * @return the pions
     */
    public List<Pion> getPions() {
        return pions;
    }

    /**
     * Sets pions.
     *
     * @param pions the pions
     */
    public void setPions(List<Pion> pions) {
        this.pions = pions;
    }

    /**
     * Gets joueurs.
     *
     * @return the joueurs
     */
    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    /**
     * Sets joueurs.
     *
     * @param joueurs the joueurs
     */
    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

}

package org.centrale;

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


        while (plateau.isGameFinished().equals("Partie non finie")) {
            plateau.tourDeJeu();
        }

        switch (plateau.isGameFinished()) {
            case "Blanc a gagné":
                System.out.println("Le joueur " + plateau.getJoueurs().get(0).getNom() + " a gagné ! GG !!!");
                break;
            case "Noir a gagné":
                System.out.println("Le joueur " + plateau.getJoueurs().get(1).getNom() + " a gagné ! GG !!!");
                break;
            default:
                System.out.println("Une erreur s'est produite");
        }
    }
}

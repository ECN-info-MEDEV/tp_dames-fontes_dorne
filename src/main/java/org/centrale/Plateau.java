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

    private int tour;

    private Scanner scanner;


    /**
     * Constructeur vide
     */
    public Plateau() {
        this.pions = new ArrayList<>();
        this.joueurs = new ArrayList<>();
        this.tour = 0;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Constructeur
     *
     * @param pions the pions
     * @param joueurs the joueurs
     * @param tour    the tour
     */
    public Plateau(List<Pion> pions, List<Joueur> joueurs, int tour) {
        this.pions = pions;
        this.joueurs = joueurs;
        this.tour = tour;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Méthode d'initialisation du plateau de jeu
     */
    public void init(){

        //Création des Pions
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {

                if (i == 5 || i == 6) {
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
        System.out.println("Quel est le nom du joueur 1 ?");
        String nom1 = scanner.nextLine();
        this.getJoueurs().add(new Joueur(Couleur.BLANC, nom1));
        System.out.println(this.getJoueurs().get(0).toString());

        System.out.println("Quel est le nom du joueur 2 ?");
        String nom2 = scanner.nextLine();
        this.getJoueurs().add(new Joueur(Couleur.NOIR, nom2));
        System.out.println(this.getJoueurs().get(1).toString());

        //Fin de l'initialisation du jeu
        System.out.println("Jouons au jeu de Dames !\n");

        System.out.println(this);
    }

    /**
     * Méthode permettant à un joueur de jouer, en fonction du nombre de tour écoulé
     */
    public void tourDeJeu() {

        boolean isDeplacementValide = false;
        int lignePion;
        int colonnePion;
        int ligneDestination;
        int colonneDestionation;


        while (!isDeplacementValide) {
            if (tour % 2 == 0) {
                //Au tour du joueur Blanc de jouer
                System.out.println("Au tour de " + joueurs.get(0).getNom() + " de jouer !\n");
            } else {
                //Au tour du joueur Noir de jouer
                System.out.println("Au tour de " + joueurs.get(1).getNom() + " de jouer !\n");
            }

            System.out.println("Quel pion souhaites-tu déplacer ?\nDonne sa ligne puis sa colonne");
            lignePion = scanner.nextInt();
            colonnePion = scanner.nextInt();

            Pion pion_selectionne = getPionFromPosition(lignePion, colonnePion);

            if(pion_selectionne != null) {
                System.out.println("Où souhaites tu déplacer ce pion ?\nDonne sa ligne puis sa colonne");
                ligneDestination = scanner.nextInt();
                colonneDestionation = scanner.nextInt();

                System.out.println("lignePion : " + lignePion);
                System.out.println("colonnePion : " + colonnePion);
                System.out.println("ligneDestination : " + ligneDestination);
                System.out.println("colonneDestionation : " + colonneDestionation);
                Point2D position_choisie = new Point2D(ligneDestination, colonneDestionation);
                isDeplacementValide = verifDeplacement(pion_selectionne.getPosition(), position_choisie);
                if (!isDeplacementValide) {
                    System.out.println("Déplacement invalide ! Veuillez recommencer >:(");
                }
            } else {

            }


        }

        //Incrémentation du compteur de tour une fois l'action effectuée
        this.tour++;
    }

    public boolean verifDeplacement(Point2D positionDepart, Point2D positionSuivante) {
        int xInit = positionDepart.getX();
        int yInit = positionDepart.getY();
        int xNext = positionSuivante.getX();
        int yNext = positionSuivante.getY();

        ArrayList<Point2D> positionAutorisees = new ArrayList<>();
        int[] translations = new int[]{-1, 1};
        for (int i : translations) {
            for (int j : translations) {
                Point2D position = new Point2D(xInit + i, yInit + j);

                positionAutorisees.add(position);
            }
        }

        // Position parmi celles autorisees
        boolean autorise = false;
        for (Point2D pos : positionAutorisees) {
            if (pos.equals(positionSuivante)) {
                autorise = true;
                break;
            }
        }
        if (!autorise) {
            return false;
        }
        // Position dans le plateau
        if (yNext > 10 | yNext < 0 | xNext > 10 | xNext < 0) {
            System.out.println("hors plateau");
            return false;
        }
        // Position non occupee
        for (Pion pion : this.pions) {
            if (pion.getPosition().equals(positionSuivante)) {
                System.out.println("Occupee");
                return false;
            }
        }

        return true;
    }

    private Pion getPionFromPosition(int lignePion, int colonnePion) {
        Point2D position = new Point2D(lignePion, colonnePion);

        for (Pion pion : pions) {
            if (pion.getPosition().equals(position)) {
                return pion;
            }
        }

        return null;
    }

    /**
     * Méthode vérifiant si la partie est finie
     *
     * @return the boolean
     */
    public String isGameFinished() {

        //Test sur fin de partie
        if (pions.stream().anyMatch(o -> o.getCouleur().equals(Couleur.NOIR))
                && pions.stream().anyMatch(o -> o.getCouleur().equals(Couleur.BLANC))) {
            return "Partie non finie";
        } else if (pions.stream().anyMatch(o -> o.getCouleur().equals(Couleur.NOIR))){
            return "Noir a gagné";
        } else if (pions.stream().anyMatch(o -> o.getCouleur().equals(Couleur.BLANC))){
            return "Blanc a gagné";
        } else {
            return "Une erreur s'est produite";
        }
    }

    @Override
    public String toString() {
        String visu = """
                   1 2 3 4 5 6 7 8 9 10
                1   | | | | | | | | |\s
                2   | | | | | | | | |\s
                3   | | | | | | | | |\s
                4   | | | | | | | | |\s
                5   | | | | | | | | |\s
                6   | | | | | | | | |\s
                7   | | | | | | | | |\s
                8   | | | | | | | | |\s
                9   | | | | | | | | |\s
                10  | | | | | | | | |\s
                """;

        int position;
        for (Pion pion : pions) {
            position = (pion.getPosition().getX() - 1) * 23 + (pion.getPosition().getY() - 1) * 2 + 27;
            visu = visu.substring(0, position) + pion + visu.substring(position + 1);
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

package org.centrale;

import java.util.ArrayList;
import java.util.List;

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
        return visu;
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

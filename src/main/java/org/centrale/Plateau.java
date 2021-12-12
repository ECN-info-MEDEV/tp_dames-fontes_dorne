package org.centrale;

import java.util.List;

/**
 * Classe Plateau
 */
public class Plateau {

    private List<Pion> pions;

    private List<Joueur> joueurs;


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
        return "Plateau{" +
                "pions=" + pions +
                ", joueurs=" + joueurs +
                '}';
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

package org.centrale;

/**
 * Classe Joueur
 */
public class Joueur {

    private Couleur couleur;


    /**
     * Constructeur
     *
     * @param couleur the couleur
     */
    public Joueur(Couleur couleur) {
        this.couleur = couleur;
    }


    /**
     * Gets couleur.
     *
     * @return the couleur
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Sets couleur.
     *
     * @param couleur the couleur
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
}

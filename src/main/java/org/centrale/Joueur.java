package org.centrale;

/**
 * Classe Joueur
 */
public class Joueur {

    private Couleur couleur;

    private String nom;


    /**
     * Constructeur
     *
     * @param couleur the couleur
     * @param nom the nom
     */
    public Joueur(Couleur couleur, String nom) {
        this.couleur = couleur;
        this.nom = nom;
    }


    @Override
    public String toString() {
        if (couleur == Couleur.BLANC) {
            return nom + " joue les pions blancs";
        } else {
            return nom + " joue les pions noirs";
        }
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

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}

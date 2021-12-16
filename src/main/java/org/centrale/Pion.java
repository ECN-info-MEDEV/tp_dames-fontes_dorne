package org.centrale;

/**
 * Classe Pion
 */
public class Pion {

    private Point2D position;

    private Couleur couleur;


    /**
     * Constructeur
     *
     * @param position the position
     * @param couleur  the couleur
     */
    public Pion(Point2D position, Couleur couleur) {
        this.position = position;
        this.couleur = couleur;
    }

    /**
     * Constructeur de recopie
     *
     * @param pion the pion
     */
    public Pion(Pion pion) {
        this.position = pion.getPosition();
        this.couleur = pion.getCouleur();
    }


    @Override
    public String toString() {
        if (this.getCouleur() == Couleur.BLANC){
            return "x";
        } else {
            return "o";
        }
    }


    /**
     * Gets position.
     *
     * @return the position
     */
    public Point2D getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(Point2D position) {
        this.position = position;
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

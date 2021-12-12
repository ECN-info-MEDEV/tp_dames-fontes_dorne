package org.centrale;

/**
 * Classe Dame
 */
public class Dame extends Pion {

    /**
     * Constructeur
     *
     * @param position the position
     * @param couleur  the couleur
     */
    public Dame(Point2D position, Couleur couleur) {
        super(position, couleur);
    }

    /**
     * Constructeur de recopie
     *
     * @param pion the pion
     */
    public Dame(Pion pion){
        super(pion);
    }


    @Override
    public String toString() {
        if (this.getCouleur() == Couleur.BLANC){
            return "■";
        } else {
            return "□";
        }
    }

}

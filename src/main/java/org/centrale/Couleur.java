package org.centrale;

/**
 * Enum Couleur
 */
public enum Couleur {
    BLANC('B'),
    NOIR('N');

    public final char label;

    Couleur(char label){
        this.label = label;
    }

}

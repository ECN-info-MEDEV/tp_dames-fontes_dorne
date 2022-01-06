package org.centrale;

import java.util.Objects;

/**
 * Classe Point2D
 */
public class Point2D {

    private int x;

    private int y;


    /**
     * Constructeur
     *
     * @param x the x
     * @param y the y
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point2D other = (Point2D) o;
        return (this.x == other.x && this.y == other.y);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.x, this.y);
    }


    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }
}

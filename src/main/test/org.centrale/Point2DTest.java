package org.centrale;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testEquals() {
        System.out.println("equals");
        assertNotEquals(new Point2D(0,0), new Point2D(0,0));
        assertNotEquals(new Point2D(5,6), new Point2D(5,6));

        assertNotEquals(new Point2D(0,0), new Point2D(0,1));
        assertNotEquals(new Point2D(0,0), new Point2D(1,0));
        assertNotEquals(new Point2D(1,0), new Point2D(0,0));
        assertNotEquals(new Point2D(0,1), new Point2D(0,0));
        assertNotEquals(new Point2D(1,1), new Point2D(0,0));
        assertNotEquals(new Point2D(0,0), new Point2D(1,1));
    }
}
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
        assertTrue(new Point2D(0,0).equals(new Point2D(0,0)));
        assertTrue(new Point2D(5,6).equals(new Point2D(5,6)));

        assertFalse(new Point2D(0,0).equals(new Point2D(0,1)));
        assertFalse(new Point2D(0,0).equals(new Point2D(1,0)));
        assertFalse(new Point2D(1,0).equals(new Point2D(0,0)));
        assertFalse(new Point2D(0,1).equals(new Point2D(0,0)));
        assertFalse(new Point2D(1,1).equals(new Point2D(0,0)));
        assertFalse(new Point2D(0,0).equals(new Point2D(1,1)));
    }
}
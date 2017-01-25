package com.ildo.rest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


import com.ildo.rest.mars.Compass;

public class CompassTest {

    private Compass compass;

    @Before
    public void init() {
        compass = new Compass();
    }

    @Test
    public void L_should_rotate_N_to_W() {
        assertEquals('W', compass.getSibling('N', 'L'));
    }

    @Test
    public void L_should_rotate_E_to_N() {
        assertEquals('N', compass.getSibling('E', 'L'));
    }

    @Test
    public void L_should_rotate_S_to_E() {
        assertEquals('E', compass.getSibling('S', 'L'));
    }

    @Test
    public void R_should_rotate_N_to_E() {
        assertEquals('E', compass.getSibling('N', 'R'));
    }

    @Test
    public void R_should_rotate_E_to_S() {
        assertEquals('S', compass.getSibling('E', 'R'));
    }

    @Test
    public void L_should_rotate_W_to_S() {
        assertEquals('S', compass.getSibling('W', 'L'));
    }

    @Test
    public void R_should_rotate_S_to_W() {
        assertEquals('W', compass.getSibling('S', 'R'));
    }

    @Test
    public void R_should_rotate_W_to_N() {
        assertEquals('N', compass.getSibling('W', 'R'));
    }

}

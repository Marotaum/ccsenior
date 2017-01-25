package com.ildo.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ildo.rest.mars.Position;

public class PositionTest {

    private Position position;

    @Before
    public void init() {
        position = new Position();
    }

    @Test
    public void x_should_start_0() { assertEquals(0, position.getX()); }

    @Test
    public void y_should_start_0() {
        assertEquals(0, position.getY());
    }

    @Test
    public void location_should_start_00N() {
        assertEquals( "(0, 0, N)", position.toString());
    }

    @Test
    public void command_L_should_change_location() {
        position.update('L');
        assertEquals( "(0, 0, W)", position.toString());
    }

    @Test
    public void command_M_should_change_location() {
        position.update('M');
        assertEquals( "(0, 1, N)", position.toString());
    }

    @Test
    public void command_R_should_change_location() {
        position.update('R');
        assertEquals( "(0, 0, E)", position.toString());
    }

    @Test
    public void wrong_command_should_be_ignored() {
        position.update('A');
        position.update('B');
        position.update('1');
        position.update('+');
        assertEquals( "(0, 0, N)", position.toString());
    }

}

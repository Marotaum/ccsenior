package com.ildo.rest;

import static org.junit.Assert.assertEquals;

import com.ildo.rest.mars.Position;
import org.junit.Before;
import org.junit.Test;

import com.ildo.rest.mars.Robot;

import java.util.ArrayList;

public class RobotTest {

    private Robot robot;

    @Before
    public void init() {
        robot = new Robot();
    }

    @Test
    public void location_should_start_00N() {
        assertEquals( "(0, 0, N)", robot.getPosition().toString());
    }

    @Test
    public void command_M_should_be_executed() {
        ArrayList<String> commandList = new ArrayList<String>();
        commandList.add("M");

        assertEquals( true, robot.executeCommands(commandList));
    }

    @Test
    public void command_M_should_change_location() {
        ArrayList<String> commandList = new ArrayList<String>();
        commandList.add("M");
        robot.executeCommands(commandList);
        assertEquals( "(0, 1, N)", robot.getPosition().toString());
    }
}

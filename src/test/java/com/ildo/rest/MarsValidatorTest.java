package com.ildo.rest;

import org.junit.Before;
import org.junit.Test;

import com.ildo.rest.mars.MarsValidator;

import static org.junit.Assert.assertEquals;

public class MarsValidatorTest {

    private MarsValidator marsValidatorCorrect;
    private MarsValidator marsValidatorWrongInput;
    private MarsValidator marsValidatorWrongMove;

    @Before
    public void init() {
        marsValidatorCorrect = new MarsValidator("MMLR");
        marsValidatorWrongInput = new MarsValidator("MMLRx");
        marsValidatorWrongMove = new MarsValidator("MMMLRMLLMMMMM");
    }

    @Test
    public void good_command_should_be_allowed_and_return_command_list() {
        assertEquals(4, marsValidatorCorrect.getCommandList().size() );
    }

    @Test
    public void good_command_should_be_allowed_and_have_command_list_valid() {
        assertEquals(true, marsValidatorCorrect.isCommandListValid() );
    }

    @Test
    public void good_command_should_be_allowed_and_have_future_position_valid() {
        assertEquals(true, marsValidatorCorrect.isFuturePositionValid() );
    }

    @Test
    public void wrong_input_command_should_be_return_command_list_empty() {
        assertEquals(0, marsValidatorWrongInput.getCommandList().size() );
    }

    @Test
    public void wrong_input_command_should_have_command_list_invalid() {
        assertEquals(false, marsValidatorWrongInput.isCommandListValid() );
    }

    @Test
    public void wrong_move_command_should_have_command_list_valid() {
        assertEquals(true, marsValidatorWrongMove.isCommandListValid() );
    }

    @Test
    public void wrong_move_command_should_have_future_position_invalid() {
        assertEquals(false, marsValidatorWrongMove.isFuturePositionValid() );
    }
}

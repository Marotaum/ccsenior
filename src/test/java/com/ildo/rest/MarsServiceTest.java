package com.ildo.rest;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.ildo.rest.mars.MarsService;

public class MarsServiceTest {

    private URI baseURI;
    private UriInfo uriInfo;
    private MarsService marsService;

    @Before
    public void setUp() throws Exception {
        marsService = new MarsService();

        baseURI = URI.create("http://rest.teste.com/rest/");
        uriInfo = mock(UriInfo.class);
        when(uriInfo.getBaseUri()).thenReturn(baseURI);
    }

    @Test
    public void good_command_should_be_executed_and_result_200() {
        Response response = marsService.move(uriInfo, "MMLR");
        assertEquals(200, response.getStatus());
    }

    @Test
    public void good_command_should_be_executed_and_result_02N() {
        Response response = marsService.move(uriInfo, "MMLR");
        assertEquals("(0, 2, N)", response.getEntity());
    }

    @Test
    public void wrong_input_command_should_be_result_400() {
        Response response = marsService.move(uriInfo, "MMLRx");
        assertEquals(400, response.getStatus());
    }

    @Test
    public void wrong_move_command_should_be_result_400() {
        Response response = marsService.move(uriInfo, "MMMLRMLLMMMMM");
        assertEquals(400, response.getStatus());
    }

}

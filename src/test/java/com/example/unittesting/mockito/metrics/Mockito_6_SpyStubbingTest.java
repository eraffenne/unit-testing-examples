package com.example.unittesting.mockito.metrics;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

/**
 * Created by Luca Rosellini <lrosellini@keedio.com> on 23/4/15.
 */
public class Mockito_6_SpyStubbingTest {

    private UnitTestingMetrics controller;

    @Before
    public void setup(){
        controller = spy(new UnitTestingMetrics());

        controller.state = "OLD_STATE";
    }

    @Test
    public void testStubWhen(){
        when(controller.setNewState("OK")).thenReturn("STUBBED_OK");

        controller.setNewState("OK");

        assertEquals("OK", controller.state);
    }

    @Test
    public void testStubDoReturn(){
        doReturn("STUBBED_OK").when(controller).setNewState("OK");

        controller.setNewState("OK");

        assertEquals("OLD_STATE", controller.state);
    }
}

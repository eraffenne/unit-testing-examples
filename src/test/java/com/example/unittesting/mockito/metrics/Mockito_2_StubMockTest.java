package com.example.unittesting.mockito.metrics;

import com.codahale.metrics.Meter;
import org.junit.Before;
import org.junit.Test;

import static com.example.unittesting.mockito.metrics.MetricsEvent.PROCESS_OK;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by Luca Rosellini <lrosellini@keedio.com> on 23/4/15.
 */
public class Mockito_2_StubMockTest {
    private UnitTestingMetrics controller;

    @Before
    public void setup(){
        controller = new UnitTestingMetrics();
        controller.deliveryOk = mock(Meter.class);

        when(controller.deliveryOk.getOneMinuteRate()).thenReturn(11D);
        doThrow(IllegalAccessException.class).when(controller.deliveryOk).mark();
    }

    @Test
    public void testFiveMinutesRatesStub(){
        double delta = 0;
        assertEquals("DeliveryOk One-Minute-Rate should be 11", 11D,
                controller.getDeliveryOkOneMinuteRate(), delta);
    }

    @Test
    public void testNotStubbedValue(){
        double delta = 0;
        assertEquals("DeliveryOk Fifteen-Minute-Rate should be zero", 0.0,
                controller.getDeliveryOkFifteenMinuteRate(), delta);
    }

    @Test(expected = IllegalAccessException.class)
    public void testExceptionOnMark(){
        controller.manage(new MetricsEvent(PROCESS_OK));
    }
}

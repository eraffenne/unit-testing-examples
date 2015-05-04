package com.example.unittesting.mockito.metrics;

import com.codahale.metrics.Meter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.exceptions.misusing.NotAMockException;

import static org.mockito.Mockito.*;
import static com.example.unittesting.mockito.metrics.MetricsEvent.*;

/**
 * Created by Luca Rosellini <lrosellini@keedio.com> on 23/4/15.
 */
public class Mockito_0_CreateMockTest {
    private UnitTestingMetrics controller;

    //
    @Before
    public void setup(){
        controller = new UnitTestingMetrics().init();

        controller.deliveryOk = mock(Meter.class);
    }

    @Test
    public void createMock(){
        controller.manage(new MetricsEvent(PROCESS_OK));
    }

    @Test
    public void createMockAndVerifyBasicInteraction_0(){
        controller.manage(new MetricsEvent(PROCESS_OK));

        verify(controller.deliveryOk).mark();
    }

    @Test
    public void createMockAndVerifyBasicInteraction_1(){
        controller.manage(new MetricsEvent(PROCESS_OK));

        verify(controller.deliveryOk, times(1)).mark();
    }

    @Test(expected = NotAMockException.class)
    public void createMockAndVerifyOverNotMockedObject(){
        controller.manage(new MetricsEvent(PROCESS_ERROR));
        verify(controller.processError).mark();
    }

}

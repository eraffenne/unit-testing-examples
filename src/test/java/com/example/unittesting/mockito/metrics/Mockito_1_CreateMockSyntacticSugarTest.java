package com.example.unittesting.mockito.metrics;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.exceptions.misusing.NotAMockException;
import org.mockito.runners.MockitoJUnitRunner;

import static com.example.unittesting.mockito.metrics.MetricsEvent.PROCESS_ERROR;
import static com.example.unittesting.mockito.metrics.MetricsEvent.PROCESS_OK;
import static com.example.unittesting.mockito.metrics.MetricsEvent.PROCESS_TIME;
import static org.mockito.Mockito.*;

/**
 * Created by Luca Rosellini <lrosellini@keedio.com> on 23/4/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class Mockito_1_CreateMockSyntacticSugarTest {

    @InjectMocks
    private UnitTestingMetrics controller;

    @Mock
    private Meter deliveryOk;

    @Mock
    private Meter deliveryError;

    @Mock
    private Meter processError;

    @Test
    public void createMock(){
        controller.manage(new MetricsEvent(PROCESS_OK));
    }

    @Test
    public void createMockAndVerifyBasicInteraction_0(){
        controller.manage(new MetricsEvent(PROCESS_OK));

        verify(controller.deliveryOk).mark();
        verifyNoMoreInteractions(controller.deliveryOk);
    }

    @Test
    public void createMockAndVerifyBasicInteraction_1(){
        controller.manage(new MetricsEvent(PROCESS_OK));

        verify(controller.deliveryOk, times(1)).mark();
        verifyNoMoreInteractions(controller.deliveryOk);
    }

    @Test(expected = NotAMockException.class)
    public void createMockAndVerifyOverNotMockedObject(){
        controller.init();

        controller.manage(new MetricsEvent(PROCESS_OK));
        verify(controller.deliveryOk).mark();
        verifyNoMoreInteractions(controller.deliveryOk);
    }
}

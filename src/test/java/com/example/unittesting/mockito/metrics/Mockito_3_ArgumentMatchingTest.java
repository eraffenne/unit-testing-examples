package com.example.unittesting.mockito.metrics;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Luca Rosellini <lrosellini@keedio.com> on 23/4/15.
 */
public class Mockito_3_ArgumentMatchingTest {

    private UnitTestingMetrics controller;

    private MetricRegistry metricRegistry;
    private Meter deliveryOk;
    private Meter processError;
    private Histogram processTime;

    @Before
    public void setup(){
        metricRegistry = mock(MetricRegistry.class);
        deliveryOk = mock(Meter.class);
        processError = mock(Meter.class);
        processTime = mock(Histogram.class);

        // specific string matcher
        when(metricRegistry.meter("deliveryOk")).thenReturn(deliveryOk);
        when(metricRegistry.meter("processError")).thenReturn(processError);

        // predefined Mockito matcher
        when(metricRegistry.histogram( anyString() )).thenReturn(processTime);

        controller = new UnitTestingMetrics().init(metricRegistry);

        when(deliveryOk.getOneMinuteRate()).thenReturn(0.1D);
        when(processError.getOneMinuteRate()).thenReturn(0.5D);

    }

    @Test
    public void testOneMinutesRatesStubs(){
        double delta = 0;

        verify(deliveryOk, never()).getOneMinuteRate();
        verify(processError, never()).getOneMinuteRate();

        assertEquals("DeliveryOk One-Minute-Rate should be 0.1", 0.1D,
                controller.getDeliveryOkOneMinuteRate(), delta);

        verify(deliveryOk, times(1)).getOneMinuteRate();

        assertEquals("DeliveryOk One-Minute-Rate should be 0.1", 0.1D,
                controller.getDeliveryOkOneMinuteRate(), delta);

        verify(deliveryOk, atLeast(1)).getOneMinuteRate();

        assertEquals("ProcessError One-Minute-Rate should be 0.5", 0.5D,
                controller.getProcessErrorOneMinuteRate(), delta);

        verify(processError, times(1)).getOneMinuteRate();

        assertEquals("ProcessError One-Minute-Rate should be 0.5", 0.5D,
                controller.getProcessErrorOneMinuteRate(), delta);

        verify(processError, atLeast(1)).getOneMinuteRate();
    }

    @Test
    public void testVerifyWithMatcher(){
        verify(metricRegistry, times(3)).meter( anyString() );
        verify(metricRegistry, times(1)).histogram( anyString() );

    }
}

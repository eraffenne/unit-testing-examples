package com.example.unittesting.mockito.metrics;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Luca Rosellini <lrosellini@keedio.com> on 23/4/15.
 */
public class Mockito_5_SpyTest {

    private UnitTestingMetrics controller;
    private MetricRegistry metricRegistrySpy;

    @Before
    public void setup(){
        metricRegistrySpy = spy(new MetricRegistry());

        controller = new UnitTestingMetrics().init(metricRegistrySpy);
    }

    @Test
    public void testSpyInteractions(){
        verify(metricRegistrySpy, times(3)).meter(anyString());
        verify(metricRegistrySpy, times(1)).histogram("processTime");
        verify(metricRegistrySpy, never()).histogram("");
    }
}

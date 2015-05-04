package com.example.unittesting.mockito.metrics;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Luca Rosellini <lrosellini@keedio.com> on 23/4/15.
 */
public class Mockito_4_ArgumentCaptorTest {

    private UnitTestingMetrics controller;

    private MetricRegistry metricRegistry;
    private Histogram processTime;

    private ArgumentCaptor<Long> captor;

    @Before
    public void setup(){
        captor = ArgumentCaptor.forClass(Long.class);

        metricRegistry = mock(MetricRegistry.class);
        processTime = mock(Histogram.class);

        // predefined Mockito matcher
        when(metricRegistry.histogram( anyString() )).thenReturn(processTime);
        controller = new UnitTestingMetrics().init(metricRegistry);
    }

    @Test
    public void testArgumentsToHistogram(){

        controller.manage(new MetricsEvent(MetricsEvent.PROCESS_TIME, 4738L));

        verify(processTime,times(1)).update(captor.capture());

        assertEquals(4738L, captor.getValue().longValue());
    }

    @Test
    public void testCaptorMultipleInteractions(){

        Random r = new Random(31);

        int iterations = 1000;

        List<Long> randomValues = new ArrayList<>();

        for (int i = 0; i < iterations; i++){
            long value = r.nextLong();
            randomValues.add(value);

            controller.manage(new MetricsEvent(MetricsEvent.PROCESS_TIME, value));
        }

        verify(processTime,times(iterations)).update(captor.capture());

        assertEquals(iterations, captor.getAllValues().size());

        assertEquals(randomValues, captor.getAllValues());
    }
}

package com.example.unittesting.fixtures;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutTest {

    @Rule
    public Timeout timeout = Timeout.millis(500L);

    @Test
    public void testTimeoutUsingRule()  throws InterruptedException {
        Thread.sleep(600L);
    }

    /**
     * Important!!!
     * Shows use of timeout in test annotation. However be aware that if a rule
     * exists, the annotation will override the rule ONLY when it sets a shorter
     * timeout.
     *
     * @throws InterruptedException
     */
    @Test(timeout = 400L)
    public void testTimeoutUsingAnnotation() throws InterruptedException {
        System.out.println("Running Test 4 that will fail");
        Thread.sleep(300L);
    }
}

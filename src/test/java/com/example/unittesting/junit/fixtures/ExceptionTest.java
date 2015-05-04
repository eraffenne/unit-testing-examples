package com.example.unittesting.junit.fixtures;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class ExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testExceptionUsingRule() {
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.reportMissingExceptionWithMessage("No exception was thrown.");

        new ArrayList<Object>().get(0);
    }

    @Test(expected = NullPointerException.class)
    public void testExceptionUsingAnnotation() {
        throw new NullPointerException();
    }


}

package com.example.unittesting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testExceptionUsingRule() {
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.reportMissingExceptionWithMessage("No exception was thrown.");

        List<Object> list = new ArrayList<Object>();
        list.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionWithAnnotation() {
        new ArrayList<Object>().get(0);
    }


}

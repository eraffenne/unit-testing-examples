package com.example.unittesting;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class ExpectedExceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionUsingAnnotation() {
        new ArrayList<Object>().get(0);
    }

    @Test
    public void testExceptionMessage() {
        try {
            new ArrayList<Object>().get(0);
            Assert.fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            Assert.assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
        }
    }

    @Test
    public void testExceptionUsingRule() {
        List<Object> list = new ArrayList<Object>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        thrown.reportMissingExceptionWithMessage("No exception was raised.");
        list.size(); // will fail since no exception will be thrown
    }

}

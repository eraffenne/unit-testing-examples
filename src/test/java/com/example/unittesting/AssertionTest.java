package com.example.unittesting;

import com.example.unittesting.runners.suite.MyCategory;
import org.hamcrest.Matcher;
import org.hamcrest.core.StringStartsWith;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AssertionTest {

    @Test
    @Category({MyCategory.class})
    public void testEquals() {
        System.out.println("Running testEquals");
        String expected = "Hola";

        String myTestString = "hola".replaceFirst("h", "H");
        Assert.assertEquals("These have different values", expected, myTestString);
    }

    @Test
    public void testArrayEquals() {
        String[] expected = new String[]{"uno", "dos", "tres"};

        String[] myTestArray = new String[]{"uno", "dos", "tres"};
        Assert.assertArrayEquals("Arrays are different. Check the order of elements.", expected, myTestArray);
    }

    @Test
    public void testTrue() {
        Assert.assertTrue("String length is not the correct", "hola".length() == 4);
    }

    @Test
    public void testNull() {
        String myString = null;
        Assert.assertNull("String already initialized", myString);
    }

    @Test
    public void testNotSame() {
        String expected = "Hola";

        String myTestString = "hola".replaceFirst("h", "H");
        Assert.assertNotSame("These are the same object.", expected, myTestString);

    }

    @Test
    public void testThat() {
        Matcher myMatcher = new StringStartsWith("H");

        String myTestString = "Hola";
        Assert.assertThat("First letter is not right.", myTestString, myMatcher);
    }
}

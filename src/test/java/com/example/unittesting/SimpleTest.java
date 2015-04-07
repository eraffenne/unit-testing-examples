package com.example.unittesting;

import com.example.unittesting.runners.suite.MyCategory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleTest {

    @Test
    @Category({MyCategory.class})
    public void testOne() {
        System.out.println("Running Test 1");

        // Arrange
        String aString = "Hello world!";

        // Act
        String subString = aString.substring(1,3);

        // Assert
        Assert.assertEquals("Substring is not right.", "el", subString);

    }

    @Test
    @Ignore
    public void testToBeIgnored() {
        System.out.println("I should be ignored");
        Assert.fail("This should never happen. I'm supposed to be ignored!!");
    }

    @Test
    public void testTwo() {
        System.out.println("Running Test 2");

    }

    @Test
    public void testThree() {
        System.out.println("Running Test 3");

    }
}
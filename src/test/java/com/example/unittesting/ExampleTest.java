package com.example.unittesting;

import org.junit.Assert;
import org.junit.Test;

public class ExampleTest {

    @Test
    public void testSubString() {

        // Arrange
        String aString = "Hello world!";

        // Act
        String subString = aString.substring(1,3);

        // Assert
        Assert.assertEquals("el", subString);

    }
}

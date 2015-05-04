package com.example.unittesting.junit;

import org.junit.Assert;
import org.hamcrest.CoreMatchers;
import org.junit.Assume;
import org.junit.Test;

import java.io.File;

public class AssumptionTest {

    @Test
    public void testAssumeThatIgnored() {
        Assume.assumeThat("Test ignored.", String.valueOf(File.separatorChar), CoreMatchers.is("\\"));

        Assert.assertEquals("Wrong path.", "/tmp/filename.ext", new File("/tmp/filename.ext").getAbsolutePath());
    }

    @Test
    public void testAssumeThat() {
        Assume.assumeThat("Test ignored.", String.valueOf(File.separatorChar), CoreMatchers.is("/"));

        Assert.assertEquals("Wrong path.", "/tmp/filename.ext", new File("/tmp/filename.ext").getAbsolutePath());
    }
}

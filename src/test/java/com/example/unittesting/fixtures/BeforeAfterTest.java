package com.example.unittesting.fixtures;

import com.example.unittesting.helpers.FakeResource;
import org.junit.*;

import java.io.IOException;

public class BeforeAfterTest {

    private static FakeResource myResource;

    @BeforeClass
    public static void setUpClass() {
        myResource = new FakeResource();
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
        myResource.close();
        System.out.println("@AfterClass");
    }

    @Before
    public void setUp() throws Exception {
        myResource.setDatum("setting up");
        System.out.println("@Before Datum is: " + myResource.getDatum());
    }

    @After
    public void tearDown() throws Exception {
        myResource.setDatum("tearing down");
        System.out.println("@After Datum is: " + myResource.getDatum());
    }

    @Test
    public void testOne() {
        System.out.println("@Test testOne");
        Assert.assertEquals("String is not the expected one", "setting up", myResource.getDatum());
    }

    @Test
    public void testTwo() {
        System.out.println("@Test testTwo");
        Assert.assertEquals("String is not the expected one", "setting up", myResource.getDatum());
    }

}


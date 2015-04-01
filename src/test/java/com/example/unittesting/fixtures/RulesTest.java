package com.example.unittesting.fixtures;

import com.example.unittesting.helpers.FakeServer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;

import java.io.File;
import java.io.IOException;

public class RulesTest {

    private FakeServer myServer = new FakeServer(44444);

    // ------------------------- Rules ----------------------------------

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() {
            System.out.println("ExternalResource Rule.before(): starting server");
            myServer.start();
        }

        @Override
        protected void after() {
            System.out.println("ExternalResource Rule.after(): stopping server");
            myServer.stop();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Rule
    public TestName name = new TestName();


    // ------------------------- Tests ----------------------------------

    @Test
    public void testWithTemporaryFolder() throws IOException {
        File createdFile = folder.newFile("myfile.txt");
        System.out.println("Temporary file: " + createdFile.getPath());
    }


    @Test
    public void testWithExternalResource() {
        System.out.println("ExternalResource listening on port: " + myServer.getPort());
    }

    @Test
    public void testNoExceptionThrown() {
        System.out.println("Testing no exception was thrown");
    }

    @Test
    public void testNullPointerException() {
        thrown.expect(NullPointerException.class);
        System.out.println("Throwing NullPointerException...");
        throw new NullPointerException();
    }

    @Test
    public void testTestName() {
        System.out.println("Checking on my name: " + name.getMethodName());
        Assert.assertEquals("testTestName", name.getMethodName());
    }

}

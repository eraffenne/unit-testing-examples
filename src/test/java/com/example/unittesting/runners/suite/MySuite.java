package com.example.unittesting.runners.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        com.example.unittesting.SimpleTest.class,
        com.example.unittesting.AssertionTest.class})
public class MySuite {

    // Intentionally left blank

}

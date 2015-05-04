package com.example.unittesting.junit.runners.suite;

import com.example.unittesting.junit.AssertionTest;
import com.example.unittesting.junit.SimpleTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SimpleTest.class,
        AssertionTest.class})
public class MySuite {

    // Intentionally left blank

}

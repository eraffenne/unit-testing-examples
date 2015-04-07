package com.example.unittesting.runners.suite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(MyCategory.class)
@Suite.SuiteClasses({
        com.example.unittesting.SimpleTest.class,
        com.example.unittesting.AssertionTest.class})
public class MyCategorizedSuite {

    // Intentionally left blank

}

package com.example.unittesting.junit.runners.suite;

import com.example.unittesting.junit.AssertionTest;
import com.example.unittesting.junit.SimpleTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(MyCategory.class)
@Suite.SuiteClasses({
        SimpleTest.class,
        AssertionTest.class})
public class MyCategorizedSuite {

    // Intentionally left blank

}

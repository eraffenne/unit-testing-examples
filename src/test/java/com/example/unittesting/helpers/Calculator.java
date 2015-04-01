package com.example.unittesting.helpers;

public class Calculator {

    static public int sumUpTo(int n) {
        if ( n >= 1 ) {
            return n + sumUpTo(n - 1);
        } else {
            return 0;
        }
    }
}

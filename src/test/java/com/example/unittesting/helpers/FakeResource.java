package com.example.unittesting.helpers;

import java.io.Closeable;
import java.io.IOException;

public class FakeResource implements Closeable {

    private String datum;

    public void close() throws IOException {
        // Intentionally left blank
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}

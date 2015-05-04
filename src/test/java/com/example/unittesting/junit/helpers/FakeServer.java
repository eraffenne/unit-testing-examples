package com.example.unittesting.junit.helpers;

public class FakeServer {

    private int port;

    public FakeServer(int port) {
        this.port = port;
    }

    public void start() {
        // Intentionally left blank
    }

    public void stop() {
        // Intentionally left blank
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

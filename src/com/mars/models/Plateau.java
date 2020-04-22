package com.mars.models;

public class Plateau {
    private Position boundary;

    public Plateau(Position boundary){
        this.boundary = boundary;
    }

    public Position getboundary() {
        return boundary;
    }
}

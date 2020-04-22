package com.mars.models;

public class Position {
    private Integer x;
    private Integer y;

    public Position(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void moveNorth(){
        this.y++ ;
    }

    public void moveEast(){
        this.x++ ;
    }

    public void moveSouth(){
        this.y-- ;
    }

    public void moveWest(){
        this.x--;
    }

    public boolean isOutside(Position boundary){
        return this.x>boundary.getX() || this.x<0 || this.y>boundary.getY() || this.y<0;
    }
}

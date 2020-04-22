package com.mars.models;


import java.util.Arrays;
import java.util.List;

public class Rover {

    private Plateau plateau;
    private Position position;
    private Character direction;

    private static final List<Character> directionsPossible = Arrays.asList('N', 'E', 'S', 'W');
    private static final TwoWayMap<Character, Integer> directionMap = new TwoWayMap<>(directionsPossible, Arrays.asList(0, 1, 2, 3));

    public Rover(Plateau plateau, Position position, char direction) throws  Exception{
        this.plateau = plateau;
        this.position = position;
        validatePosition();
        this.direction = direction;
        validateDirection();
    }

    public Position getPosition() {
        return position;
    }

    public Character getDirection() {
        return direction;
    }

    public void executeCommand(String command) throws Exception{
        char[] commandArray = command.toCharArray();
        for (Character action : commandArray) {
            this.perform(action);
        }
    }

    private void turnAntiClockwiseBy90degree(){
        this.direction = directionMap.dereferenceOf((directionMap.referenceOf(this.direction)+3)%4);
    }

    private void turnClockwiseBy90degree(){
        this.direction = directionMap.dereferenceOf((directionMap.referenceOf(this.direction)+1)%4);
    }

    private void moveForward(){
        switch (this.direction){
            case 'N' : this.position.moveNorth(); break;
            case 'E' : this.position.moveEast(); break;
            case 'S' : this.position.moveSouth(); break;
            case 'W' : this.position.moveWest(); break;
        }
    }

    private void perform(char action) throws Exception{
        switch (action) {
            case 'L': this.turnAntiClockwiseBy90degree(); break;
            case 'R': this.turnClockwiseBy90degree(); break;
            case 'M': this.moveForward(); break;
            default : throw new Exception("Illegal Command: Unknown command received by the Rover");
        }
        validatePosition();
    }

    private void validatePosition() throws  Exception {
        if(this.position.isOutside(this.plateau.getboundary()))
            throw new Exception("Illegal Position: Rover is out of Plateau");
    }

    private void validateDirection() throws Exception {
        if(!directionsPossible.contains(this.direction))
            throw new Exception("Illegal Direction: Rover direction cannot be determined");
    }
}

package com.mars.tests;

import com.mars.models.Plateau;
import com.mars.models.Position;
import com.mars.models.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    Plateau plateau;

    @BeforeEach
    void setUp() {
        plateau = new Plateau(new Position(5,5));
    }

    @Test
    void executeCommand_positive() throws Exception {
        Rover rover = new Rover(plateau, new Position(2,2), 'N');
        rover.executeCommand("RMLMMLMMRML");
        assertEquals(1,rover.getPosition().getX());
        assertEquals(5,rover.getPosition().getY());
        assertEquals('W',rover.getDirection());
    }

    @Test
    void executeCommand_outOfBounadry() {
        Exception exception = assertThrows(Exception.class, () -> {
            Rover rover = new Rover(plateau, new Position(2, 2), 'N');
            rover.executeCommand("RMLMMLMMRMLMMMMM");
        });
        assertEquals("Illegal Position: Rover is out of Plateau", exception.getMessage());
    }

    @Test
    void executeCommand_unknownDirection() {
        Exception exception = assertThrows(Exception.class, () -> {
            Rover rover = new Rover(plateau, new Position(2, 2), 'Q');
            rover.executeCommand("LRRLRL");
        });
        assertEquals("Illegal Direction: Rover direction cannot be determined", exception.getMessage());
    }

    @Test
    void executeCommand_unknownPosition() {
        Exception exception = assertThrows(Exception.class, () -> {
            Rover rover = new Rover(plateau, new Position(-1, 8), 'N');
            rover.executeCommand("RLRLRL");
        });
        assertEquals("Illegal Position: Rover is out of Plateau", exception.getMessage());
    }
}
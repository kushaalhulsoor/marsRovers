package com.mars;

import com.mars.models.Plateau;
import com.mars.models.Position;
import com.mars.models.Rover;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Application {

    private static final String SINGLE_SPACE = " ";

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] boundries = Arrays.stream(reader.readLine().split(SINGLE_SPACE)).mapToInt(Integer::parseInt).toArray();
        Plateau plateau = new Plateau(new Position(boundries[0], boundries[1]));

        String[] tempReader;
        String temp, answer = "";
        while((temp = reader.readLine())!=null && !temp.isEmpty()){
            tempReader = temp.split(SINGLE_SPACE);

            //Input Rover Information
            int x = Integer.parseInt(tempReader[0]), y = Integer.parseInt(tempReader[1]);
            char direction = tempReader[2].charAt(0);

            //Create a rover and send the command
            Rover rover = new Rover(plateau, new Position(x, y), direction);
            rover.executeCommand(reader.readLine());

            //Store the final co-ordinates
            answer = String.format("%s%d %d %s\n", answer, rover.getPosition().getX(), rover.getPosition().getY(), rover.getDirection());
        }
        System.out.println(answer+"==========");
    }
}

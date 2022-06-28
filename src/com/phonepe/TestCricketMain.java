package com.phonepe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestCricketMain {

    public static void main(String[] args) throws IOException, InvalidNumberOfPlayer, InvalidNumberOfOvers {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        int playersPerTeam = 0;
        int numOfOvers = 0;
        do {
            System.out.println("No. of players for each team: ");
            try{
                playersPerTeam = Integer.valueOf(reader.readLine());
            } catch (Exception e){
                throw new InvalidNumberOfPlayer("Invalid Input for players " + e);
            }
            if (playersPerTeam <= 11 && playersPerTeam > 1) {
                break;
            } else {
                System.out.println("Invalid No. of players, try again ");
            }
        } while ( true);

        do {
            System.out.println("No. of overs: ");
            try {
                numOfOvers = Integer.valueOf(reader.readLine());
            } catch (Exception e) {
                throw new InvalidNumberOfOvers("Invalid Input for Overs " + e);
            }
            if (numOfOvers > 0) {
                break;
            } else {
                System.out.println("Invalid No. of over, try again ");
            }
        } while ( true);

        Match match = new Match(playersPerTeam, numOfOvers);
        match.start();
    }
}

// game logic decision
// two function are needed
// 1. win/lose decision
// 2. input validation: Invalid input throw IllegalArgumentException

import java.util.Scanner;

public class Game {

    static void Inputvalidation(String in)
    {
        if(!in.equals("scissors") && !in.equals("paper") && !in.equals("rock"))
        {
            //System.out.println("your error input is: "+in);
            throw new IllegalArgumentException("Bad Choice!");
        }
    }
    static String Gamedecision(String A, String B)
    {
        String result1 = "Player 1 win!";
        String result2 = "Player 2 win!";
        String Draw = "Draw!";

        if(A.equals(B)){
            return Draw;
        }
        else if(A.equals("paper") && B.equals("rock"))
        {
            return result1;
        }
        else if(A.equals("rock") && B.equals("scissors"))
        {
            return result1;
        }
        else if(A.equals("scissors") && B.equals("paper"))
        {
            return result1;
        }
        else
        {
            return result2;
        }

    }
    // function have implements another function run()
    static void Foo()
    {
        try
        {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Player 1 choice(rock, paper or scissors):");
            String inputA = s.nextLine();
            Inputvalidation(inputA);
            System.out.println("Enter Player 2 choice(rock, paper or scissors):");
            String inputB = s.nextLine();
            Inputvalidation(inputB);

            String result = Gamedecision(inputA, inputB);
            System.out.println(result);
        }
        catch(IllegalArgumentException ex)
        {
            //System.out.println("例外說明：" + ex.getMessage());
            System.out.println(ex.toString());
            //ex.printStackTrace();
        }


    }
}

import java.lang.invoke.VarHandle;
import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        System.out.println("Choose rock, paper or scissors. 'r' for rock, 'p' for paper and 's' for scissors");
        //Generating computer output by using random integers corresponding to rock, paper, and scissors)
        Scanner scan = new Scanner(System.in);
        int computer = ((int) (Math.random() * 100)); //will give number from 0-99
        if (computer == 0) {
            computer = computer + 1; // removes 0 as an output so there are exactly 99 values rather than 100
        }
        //sets the default to off
        boolean computerRock = false;
        boolean computerPaper = false;
        boolean computerScissor = false;
        //this section of code turn the switch as to which option the computer chooses by splitting 1-99 into 3 sections of 33
        if (computer <= 33) {
            computerRock = !computerRock;
        } else if (computer > 33 && computer <= 66) {
            computerPaper = !computerPaper;
        } else if (computer > 66) {
            computerScissor = !computerScissor;
        }

        String Userinput = scan.next();//scans for user input and takes the characters
        //creates three booleans fo each choice
        boolean userScissor = false;
        boolean userRock = false;
        boolean userPaper = false;
        //checks for longer than 1 character input
        if ((Userinput.length()) != 1) {
            System.out.println("Invalid selection please play again");
            //couldn't find another method and learned about the contains() tool only method I found that works
            //Note: doesn't filter out input wth spaces like ' r' or 'r ' not sure how to fix
            /*previously used a method involving taking the first character of the input but invalid answers caused bugs
            with the input checker by needing me to input the value twice when it is correct
            */
        } else if (Userinput.contains("r")) {
            userRock = !userRock;
        } else if (Userinput.contains("p")) {
            userPaper = !userPaper;
        } else if (Userinput.contains("s")) {
            userScissor = !userScissor;
            //removes non r, p, s characters that aren't more than 1 character
        } else
            System.out.println("Invalid selection please play again");


            //coding each interaction, likely a faster way exists but this is what I could think of
            //Rock interactions
        if ((userRock && computerRock) == true) {
                System.out.println("Draw!\nComputer Choice: rock\t Player Choice: rock");
        } else if ((userRock && computerScissor) == true) {
                System.out.println("You Win!\nComputer Choice: scissors\t Player Choice: rock");
        } else if ((userRock && computerPaper) == true) {
                System.out.println("You Lose!\nComputer Choice: paper\t Player Choice: rock");
                //Paper interactions
        } else if ((userPaper && computerRock) == true) {
                System.out.println("You Win!\nComputer Choice: rock\t Player Choice: paper");
        } else if ((userPaper && computerScissor) == true) {
                System.out.println("You Lose!\nComputer Choice: scissors\t Player Choice: paper");
        } else if ((userPaper && computerPaper) == true) {
                System.out.println("Draw!\nComputer Choice: paper\t Player Choice: paper");
                //Scissors interactions
        } else if ((userScissor && computerRock) == true) {
                System.out.println("You Lose!\nComputer Choice: rock\t Player Choice: scissors");
        } else if ((userScissor && computerScissor) == true) {
                System.out.println("Draw!\nComputer Choice: scissors\t Player Choice: scissors");
        } else if ((userScissor && computerPaper) == true) {
                System.out.println("You Win!\nComputer Choice: paper\t Player Choice: scissors");
        }

    }
}


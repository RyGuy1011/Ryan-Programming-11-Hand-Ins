import java.util.Scanner;

public class Program {
    public static void main(String args[]){
        System.out.println("Would you like to Encrypt or Decrypt?");
        System.out.println("Type 'E' for encryption and 'D' for Decryption");
        Scanner scan3 = new Scanner(System.in);
        String EorD = scan3.next();
        if ((EorD.length()) != 1) {
            System.out.println("Invalid selection");
        }else if (EorD.contains("E")) {
            System.out.println("Encryption selected, please enter what you want encrypted below.");
        //Importing scanner utility to receive input from user
        Scanner scan = new Scanner(System.in);
         //Scans the first word of the input
        String Word = scan.next();
        //Scans all characters after the first word of input
        String UserInput = scan.nextLine();
        //Combines two to make complete user input while retaining the two other parts to be used later
        String UserInput2 = Word + UserInput;
        //Creating a scanner to scan words inside the user's input (excluding the first word in the string)
        Scanner scan2 = new Scanner(UserInput);
        /*Creating a loop where a integer, i, that is increased by the length of the word in the variable 'Word' plus one
        (to compensate for spaces as scan.next ignores spaces) in the clause: i=i+Word.length()+1)
        the value of 'i' starts at the length of the first word inputted by the user minus one to make sure it runs at least
        once in cases of single word inputs and makes sure the break condition is fulfilled later on as without the minus 1,
        an error will occur as an additional cycle is ran where i is one less than UserInput2.length
         */
            for (int i = Word.length()-1;i < UserInput2.length();i=i+Word.length()+1){
            /*Breaks down every word into 2 sections, aka 'substrings' of the two last letters and rest of the word.
            "Word.substring(Word.length()-2,Word.length())" is the last letter of every word as it is length of word-2
            to end of word. "Word.substring(0,(Word.length()-2))" grants all of the characters from start to the two last
            characters.
             */
                 System.out.print(Word.substring(Word.length()-2,Word.length())+Word.substring(0,(Word.length()-2))+"rj ");
            /*Code to end program when it gets to the last character rather than search for another word that doesn't exist,
            which can cause java.util.noelementexception error where it searches for elements but there are none
             */
                    if (i == UserInput2.length()-1){
                       break;
                    }else
                    /*Changes variable 'Word' to the next word in the input if there are any, as the 'if' statement
                    above would end the program if there were none
                     */
                Word = scan2.next();


        }

    }else if (EorD.contains("D")) {
            System.out.println("Decryption selected, please enter what you want decrypted below.");
            //Importing scanner utility to receive input from user
            Scanner scan = new Scanner(System.in);
            //Scans the first word of the input
            String Word = scan.next();
            //Scans all characters after the first word of input
            String UserInput = scan.nextLine();
            //Combines two to make complete user input while retaining the two other parts to be used later
            String UserInput2 = Word + UserInput;
            //Creating a scanner to scan words inside the user's input (excluding the first word in the string)
            Scanner scan2 = new Scanner(UserInput);
            //This code runs identically to the Encryption code the only difference being the process is reverted
            for (int i = Word.length()-1;i < UserInput2.length();i=i+Word.length()+1) {
                System.out.print(Word.substring(2,Word.length() - 2) + Word.substring(0,2)+" ");
            /*Breaks Loops upon meeting second last word as the previous line prints the last word and an error will occur if not broken
            and the condition is simply just the i value being greater the length minus the last scanned word/last word this changes from the code
            above in Encryption because in encryption it got longer and this method will cause can error while in decryption it gets shorter
            and that method would cause an error.
             */
                if (i > UserInput2.length()-Word.length()) {
                    break;
                } else

                    Word = scan2.next();
            }
        }else
            System.out.println("Invalid selection");
}
}

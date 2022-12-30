import java.util.Scanner;

public class Program {
    public static void main(String args[]){
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
        (to compensate for spaces as scan.next ignores spaces) in the caluse: i=i+Word.length()+1)
        the value of 'i' starts at the length of the first word inputted by the user minus one to make sure it runs at least
        once in cases of single word inputs
         */
        for (int i = Word.length()-1;i < UserInput2.length();i=i+Word.length()+1){
            /*Breaks down every word into 2 sections, aka 'substrings' of the last letter and rest of the word
            "Word.substring(Word.length()-1,Word.length())" is the last letter of every word as it is length of word-1
            to end of word. "Word.substring(0,(Word.length()-1))" grants all of the word from start to the second last
            character (Word.length()-1))
             */
            System.out.print(Word.substring(Word.length()-1,Word.length())+Word.substring(0,(Word.length()-1))+"ay ");
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

    }
}

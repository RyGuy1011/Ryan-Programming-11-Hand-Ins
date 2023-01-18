import java.util.Scanner;

public class Program {
    public static void main(String args[]){
        //Creating a local storage for allowing outputs to be saved and sets the default saved stats to none
        String SavedOutput = "";
        String SavedStatus = "No saves";
        String storage = "";
        //Creates an infinite loop so the code will run indefinitely until a break command is initiated
        //All systems run using the subscript command where the index of certain characters are used to move them around and create the encryption
        for (int x = 0; x<x+1; x++){
            storage ="";
        System.out.println("\nDo not input non-encrypted characters into the decryptor as it will not do anything but cut off characters.\nWould you like to Encrypt or Decrypt? ");
        System.out.println("Type 'E' for encryption and 'D' for Decryption. Type 'X' to end the program.");
        //Creates scanner for user input (deciding to encrypt, decrypt or end)
        Scanner scan3 = new Scanner(System.in);
        String EorD = scan3.next();
            Scanner scan = new Scanner(System.in);
            //Scans for invalid inputs
        if ((EorD.length()) != 1) {
            System.out.println("Invalid selection");
        }else if (EorD.contains("E")) {
            System.out.println("Encryption selected, please enter what you want encrypted below. Enter 'Saved' for the most recently encrypted or decrypted string");
            System.out.println("Current Save status is: "+ SavedStatus);
            System.out.println("WARNING: Inputting a already encrypted string will result in double encryption, which will need to be double decrypted.");
        //Scans for request of saved data and rejects command if there is none
            String Word = scan.next();
        if (Word.equals("Saved")){
            if (SavedOutput.equals("")){
                System.out.println("There is no saved data");
            }else if (!SavedOutput.equals("")){
                //Creates scanner that scans the first word and another that scans everything else. They are then combined into another variable
                Scanner scan4 = new Scanner(SavedOutput);
                String SavedWord = scan4.next();
                String SavedInput = scan4.nextLine();
                String SavedInput2 = SavedWord + SavedInput;
                Scanner scan5 = new Scanner(SavedInput);
                //Creates loop so program can go through each word and encrypt it
                for (int i = SavedWord.length()-1;i <= SavedInput2.length()+1;i=i+SavedWord.length()+1){
                    //Creates exception for single character long words as the -2 function would cause an error and crash
                    //Each words is subsequently saved into a temporary variable called storage before being assigned to SavedOutput when a condition is fulfilled
                    if (SavedWord.length()>1) {
                        System.out.print(SavedWord.substring(SavedWord.length() - 2, SavedWord.length()) + SavedWord.substring(0, (SavedWord.length() - 2)) + "rj ");
                        storage += SavedWord.substring(SavedWord.length() - 2, SavedWord.length()) + SavedWord.substring(0, (SavedWord.length() - 2)) + "rj ";
                    }else if (SavedWord.length()==1) {
                        System.out.print(SavedWord+"rj ");
                        storage += SavedWord+"rj ";
                    }
                    //Changes Save status
                    SavedStatus = "Encrypted";
                    if (i == SavedInput2.length() - SavedWord.length()){
                            SavedOutput = storage;
                        break;
                    }else
                    if (SavedInput.length()-SavedWord.length()>1) {
                        SavedWord = scan5.next();
                    }

            }
            }
            //Runs the other code for if the user input isn't 'Saved' and encrypts whatever is inputted next, runs on same system as above but directly
            //to SavedOutput instead (not sure why but obtains error when done this way in the other one)
        }else if (!Word.equals("Saved")){
        String UserInput = scan.nextLine();
        String UserInput2 = Word + UserInput;
        Scanner scan2 = new Scanner(UserInput);
        SavedOutput = "";
            for (int i = Word.length()-1;i <= UserInput2.length();i=i+Word.length()+1){
                if (Word.length()>1) {
                    System.out.print(Word.substring(Word.length() - 2, Word.length()) + Word.substring(0, (Word.length() - 2)) + "rj ");
                    SavedOutput = SavedOutput + Word.substring(Word.length() - 2, Word.length()) + Word.substring(0, (Word.length() - 2)) + "rj ";
                    SavedStatus = "Encrypted";
                }else if (Word.length()==1) {
                    System.out.print(Word+"rj ");
                    SavedOutput = SavedOutput +Word+"rj ";
                }
                    if (i == UserInput2.length()-1){
                       break;
                    }else
                Word = scan2.next();



        }}
//Decryption system
    }else if (EorD.contains("D")) {
            System.out.println("Decryption selected, please enter what you want decrypted below. Enter 'Saved' for the most recently encrypted or decrypted string");
            System.out.println("Current Save status is: "+ SavedStatus);
            System.out.println("WARNING: Inputting a already encrypted string will result in double encryption, which will need to be double decrypted");
                String Word2 = scan.next();
                if (Word2.equals("Saved")){
                    if (SavedOutput.equals("")){
                        System.out.println("There is no saved data");
                    }else if (!SavedOutput.equals("")){
                        Scanner scan4 = new Scanner(SavedOutput);
                        String SavedWord = scan4.next();
                        String SavedInput = scan4.nextLine();
                        String SavedInput2 = SavedWord + SavedInput;
                        Scanner scan5 = new Scanner(SavedInput);
                        for (int i = SavedWord.length()-1;i <= SavedInput2.length();i=i+SavedWord.length()+1){
                            if (SavedWord.length()>3) {
                                System.out.print(SavedWord.substring(2, SavedWord.length() - 2) + SavedWord.substring(0, 2) + " ");
                                storage = storage + SavedWord.substring(2, SavedWord.length() - 2) + SavedWord.substring(0, 2) + " ";
                            }else if (SavedWord.length()==3) {
                                System.out.print(SavedWord.substring(0,1));
                                storage = storage + SavedWord.substring(0,1);
                                //Creates exception for when words are less than 3 characters as it would not be encrypted and would only create save errors
                            }else if (Word2.length()<3){
                                    System.out.println("Invalid Input, input is not decrypted. Saved data is cleared.");
                                    SavedStatus = "No saves";
                                    SavedOutput = "";
                                    break;}
                            SavedStatus = "Not Encrypted";
                            if (i > SavedInput2.length()-SavedWord.length()){
                                SavedOutput = storage;
                                break;
                            }else
                                SavedWord = scan5.next();
                        }
                    }

                }else if (!Word2.equals("Saved")){
            String UserInput = scan.nextLine();
            String UserInput2 = Word2 + UserInput;
            Scanner scan2 = new Scanner(UserInput);
                    SavedOutput = "";
            for (int i = Word2.length()-1;i < UserInput2.length();i=i+Word2.length()+1) {
                if (Word2.length() > 3) {
                    System.out.print(Word2.substring(2, Word2.length() - 2) + Word2.substring(0, 2) + " ");
                    SavedOutput = SavedOutput + Word2.substring(2, Word2.length() - 2) + Word2.substring(0, 2) + " ";
                }else if (Word2.length() == 3) {
                    System.out.print(Word2.substring(0, 1));
                    SavedOutput = SavedOutput + Word2.substring(0, 1);
                }else if (Word2.length()<3){
                    System.out.println("Invalid Input, input is not decrypted. Saved data is cleared.");
                    SavedStatus = "No saves";
                    SavedOutput = "";
                break;}
                SavedStatus = "Not Encrypted";
                if (i > UserInput2.length()-Word2.length()) {
                    break;
                } else

                    Word2 = scan2.next();
            }}
                //break program
        }else if (EorD.contains("X")){
            break;
        }
        else{
            System.out.println("Invalid selection");
}


}}}

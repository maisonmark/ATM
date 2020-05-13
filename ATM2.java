import java.util.Scanner;
public class ATM2 {
    private static Scanner keyinput ;
    private static float balance = 0; //Since no one has used our bank before, everyone's balance starts off at 0.
    private static int anotherTransaction;//This is our anotherTransaction(); method used to prompt the user if they wanted to re-use the program.

    public static void main(String args[]) {
        keyinput = new Scanner(System.in);
        //The transaction method is called here since it is the begginning phase of our program.
        transaction();
    }

    private static void Withdraw() {//First method, which will be used to withdraw money.

    	 float amount;
                System.out.println(" Please enter amount you wish to withdraw: ");
                amount = keyinput.nextFloat();
                if (amount > balance || amount == 0) {// If the amount of $ higher than their balance (or equal to 0), this would be outputed:
                    System.out.println("You have insufficient funds\n");
                    anotherTransaction(); //This calls to the method where we ask the user if they would like to choose another transaction or exit the program.
                } else {
                    //If everything is correct, we should see that the balance has been changed after withdrawal.
                    balance = balance - amount;
                    
                    System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println(" You have withdrawn " + "["+amount+"$]"+ "\n Your new balance is " +"["+balance +"$]");
                    System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    anotherTransaction();
	
			}
	}

    private static void Deposit() { // Second method, which will be used to deposit money.  	

    	float deposit;
                System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(" Please enter amount you wish to deposit: ");
                System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                deposit = keyinput.nextFloat();
                // update balance
                balance = deposit + balance;
                System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(" You have deposited [" + deposit + "$]" + "\n Your new balance is : [" + balance + "$]");
                System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                anotherTransaction();

    }

    private static void Balance() { // Third method to check our balance.

    	   System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(" Your current balance is " + "["+ balance + "$]");
                System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                anotherTransaction();

    }

    private static void AboutUs() { // Fourth method to see factual information about the bank.

    	System.out.println(" ~~~~~~~~~~~"); 
                    System.out.println(" About us: \n" + "\n The Bank of Vanier was founded on May 9th, 2020 by creator Mark Adlao and his team of workers,\n whom are also Mark Adlao. ");
                    System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~"); 

                anotherTransaction();
    }


    private static void transaction() {//Here is where the transaction phase starts, where the user has to select what they want to do with the program.
        int choice;// choice is an integer since we prompt the user for a number as a choice.

        //Here are the list of things that the user can do.
        System.out.println("          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n          Welcome to the Bank of Vanier!\n          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" What would you like to do today?");
        System.out.println(" 1. Withdraw");
        System.out.println(" 2. Deposit");
        System.out.println(" 3. Current Balance");
        System.out.println(" 4. About us");

        choice = keyinput.nextInt();//The choice is whatever the user inputs thus the scanner usage.

        switch (choice) {
            case 1:// First selection is the option to Withdraw money
               Withdraw();

                break;
            case 2:
                //Second selection is the option to deposit some money.
            	Deposit();
                break;

            case 3:
                //Third selection is the option to check your current Balance.
          		Balance();
                break;

            case 4:
                //About us... or me rather...
            	AboutUs();
                break;

            default://This is outputed if the user inputs an invalid option.
                System.out.println("Invalid option:\n\n");
                anotherTransaction();
                break;
        }
    }
    private static void anotherTransaction() {//Sixth method, this is where the user is asked if they would wanted to restart a new transaction
        System.out.println("\n Would you like to make you another transaction?\n\n [Press 1 for another transaction]\n [Press 2 To exit]");
        anotherTransaction = keyinput.nextInt();
        if (anotherTransaction == 1) {
            transaction(); //If "1" is inputed, we would call to the transaction(); method, where the user selects a bank option.
        } else if (anotherTransaction == 2) {//Otherwise, if they were to press 2, it would exit the program.
            System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" Thank you for using The Bank Of Vanier. We hope to see you soon.");
            System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        } else {//Once again, if an invalid option has been inputed, it would output as an invalid choice.
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }
}
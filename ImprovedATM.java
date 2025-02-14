import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner NewATM = new Scanner(System.in);
        
        String accNum1 = "";
        String PIN1 = "";
        double balance = 0;
        boolean loggedIn = false;
        double resetBalance = 0;
        
    while (true) {   
        System.out.println("");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");
        String choice = NewATM.nextLine();
        
    if (choice.equals("1")) {
        System.out.print("Enter account number: ");
        accNum1 = NewATM.nextLine();
        System.out.println("Enter PIN: ");
        PIN1 = NewATM.nextLine();
        System.out.println("Account successfully registered.");
        }
    
    else if (choice.equals("2")) {
        System.out.println("Enter Account Number: ");
        String accNum2 = NewATM.nextLine();
        System.out.println("Enter PIN: ");
        String PIN2 = NewATM.nextLine();
    
        if (accNum1.equals(accNum2) && PIN1.equals(PIN2)) {
            loggedIn = true;
            System.out.println("Login successful.");
            balance = 0.0;
            
           } else {
            System.out.println("Wrong credentials. Please try again.");
        }
        
            while (loggedIn) {
                System.out.println(" ");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Logout");
                System.out.println("Enter choice: ");
                String choice2 = NewATM.nextLine();
                
                if (choice2.equals("1")) {
                    System.out.println("Current Balance: $" + balance);
                } else if (choice2.equals("2")){
                    System.out.print("Enter amount to deposit: ");
                    double deposit1 = NewATM.nextDouble();
                    balance += deposit1; 
                    System.out.println("$" + deposit1 + " deposited successfully");
                    NewATM.nextLine();
                } else if (choice2.equals("3")) {
                    System.out.println("Enter amount to withdraw: ");
                    double withdraw1 = NewATM.nextDouble();
                    if (withdraw1 <= balance) {
                        balance -= withdraw1;
                        System.out.println("$" + withdraw1 + " 4withdrawn successfully.");
                    
                  } else {
                      System.out.println("Insufficient funds.");
                  }  NewATM.nextLine();
                } else if (choice2.equals("4")) {
                    loggedIn = false;
                    System.out.println("Logged out.");
                
                } else {
                    System.out.println("Invalid choice.");
                }
            }
    } else if (choice.equals("3")) {
        System.out.println("Goodbye!");
        break;
    } else { 
        System.out.println("Invalid Choice.");
    }

    }
}
}

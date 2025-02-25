import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> accounts = new HashMap<>();
        HashMap<String, Double> balances = new HashMap<>();
        boolean loggedIn = false;
        String user1 = "";

        while (true) {
            System.out.println(" ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter account number: ");
                String accNum = scanner.nextLine();
                System.out.print("Enter PIN: ");
                String pin = scanner.nextLine();
                accounts.put(accNum, pin);
                balances.put(accNum, 0.0);
                System.out.println("Account successfully registered.");
            } 
            else if (choice.equals("2")) {
                System.out.print("Enter Account Number: ");
                String accNum = scanner.nextLine();
                System.out.print("Enter PIN: ");
                String pin = scanner.nextLine();

                if (accounts.containsKey(accNum) && accounts.get(accNum).equals(pin)) {
                    loggedIn = true;
                    user1 = accNum;
                    System.out.println("Login successful.");
                } else {
                    System.out.println("Wrong credentials. Please try again.");
                }

                while (loggedIn) {
                    System.out.println(" ");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Logout");
                    System.out.print("Enter choice: ");
                    String choice2 = scanner.nextLine();

                    if (choice2.equals("1")) {
                        System.out.println("Current Balance: $" + balances.get(user1));
                    } 
                    else if (choice2.equals("2")) {
                        System.out.print("Enter amount to deposit: ");
                        double deposit = scanner.nextDouble();
                        balances.put(user1, balances.get(user1) + deposit);
                        System.out.println("$" + deposit + " deposited successfully");
                        scanner.nextLine();
                    } 
                    else if (choice2.equals("3")) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdraw = scanner.nextDouble();
                        if (withdraw <= balances.get(user1)) {
                            balances.put(user1, balances.get(user1) - withdraw);
                            System.out.println("$" + withdraw + " withdrawn successfully.");
                        } else {
                            System.out.println("Insufficient funds.");
                        }
                        scanner.nextLine();
                    } 
                    else if (choice2.equals("4")) {
                        loggedIn = false;
                        System.out.println("Logged out.");
                    } 
                    else {
                        System.out.println("Invalid choice.");
                    }
                }
            } 
            else if (choice.equals("3")) {
                System.out.println("Goodbye!");
                break;
            } 
            else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

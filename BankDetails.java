import java.util.Scanner;

public class BankDetails {

    private String accno;
    private String name;
    private String acc_type;
    private long balance;
    Scanner sc = new Scanner(System.in);

    // method to open new account
    public void openAccount() {
        System.out.print("Enter Account No: ");
        accno = sc.next();
        System.out.print("Enter Account type: ");
        acc_type = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }

    // method to display account details
    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
    }

    // method to deposit money
    public void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance = balance + amt;
    }

    // method to withdraw money
    public void withdrawal() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
    }

    // method to search an account number
    public boolean search(String regi_acc_no) {
        if (regi_acc_no.equals(accno)) {
            showAccount();
            return (true);
        } else {
            return (false);
        }
    }

    public class BankingApp {
        public static void main(String[] args) {
            Scanner user_input = new Scanner(System.in);
            System.out.print("How many coustomer do you want to input:");
            int n = user_input.nextInt();

            BankDetails cus[] = new BankDetails[n];
            for (int i = 0; i < cus.length; i++) {
                cus[i] = new BankDetails();
                cus[i].openAccount();
            }

            int ch;
            do {
                System.out.println("\n ***Banking System Application***");
                System.out.println(
                        "1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");
                System.out.println("Enter your choice:");
                ch = user_input.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < cus.length; i++) {
                            cus[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.println("Enter account search:");
                        String ac_no = user_input.next();
                        boolean found = false;
                        for (int i = 0; i < cus.length; i++) {
                            found = cus[i].search(ac_no);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search failed! Account doesn't exist..!!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Account no. : ");
                        ac_no = user_input.next();
                        found = false;
                        for (int i = 0; i < cus.length; i++) {
                            found = cus[i].search(ac_no);
                            if (found) {
                                cus[i].deposit();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search failed! Account doesn't exist..!!");
                        }
                        break;
                    case 4:
                        System.out.print("Enter Account No : ");
                        ac_no = user_input.next();
                        found = false;
                        for (int i = 0; i < cus.length; i++) {
                            found = cus[i].search(ac_no);
                            if (found) {
                                cus[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search failed! Account doesn't exist..!!");
                        }
                        break;
                    case 5:
                        System.out.println("See you soon...");
                        break;
                }
            } while (ch != 5);

        }
    }
}

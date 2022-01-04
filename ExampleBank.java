import java.util.Scanner;

class Bank {
    private String accno;
    private String name;
    private long balance;

    Scanner B = new Scanner(System.in);

    //method to open an account
    void openAccount() 
    {
        System.out.print("Enter Account No: ");
        accno = B.next();
        System.out.print("Enter Name: ");
        name = B.next();
        System.out.print("Enter Balance: ");
        balance = B.nextLong();
    }

    //method to display account details
    void showAccount() 
    {
        System.out.println("Account No: "+accno + ", Name: " + name + ", Balance: " + balance+" Rs");
    }

    //method to deposit money
    void deposit()
    {
        long amt;
        System.out.println("Enter the Amount you want to deposit : ");
        amt = B.nextLong();
        balance = balance + amt;
    }

    //method to withdraw money
    void withdrawal()
    {
        long amt;
        System.out.println("Enter the Amount you want to withdraw : ");
        amt = B.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
        } else 
        {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }

    //method to search an account number
    boolean search(String acc) {
        if (accno.equals(acc)) 
        {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class ExampleBank {
    public static void main(String arg[]) {
        Scanner B = new Scanner(System.in);

        //create initial accounts
        System.out.print("How many customers you want to add : ");
        int n = B.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].openAccount();
        }

        //run loop until menu 5 is not pressed
        int ch;
        do 
        {
        	System.out.println("*****************************");
            System.out.println("Main Menu\n1. Display All\n2. Search By Account\n3. Deposit\n4. Withdrawal\n5. Exit ");
            System.out.println("*****************************");
            System.out.println("Enter your Choice :"); 
            ch = B.nextInt();
            System.out.println("*****************************");
            switch (ch)
            {
                    case 1:
                        for (int i = 0; i < C.length; i++)
                        {
                            C[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.print("Enter the Account No. you want to Search...: ");
                        String acc = B.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++)
                        {
                            found = C[i].search(acc);
                            if (found)
                            {
                                break;
                            }
                        }
                        if (!found)
                        {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Account No : ");
                        acc = B.next();
                        found = false;
                        for (int i = 0; i < C.length; i++)
                        {
                            found = C[i].search(acc);
                            if (found) 
                            {
                                C[i].deposit();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account No : ");
                        acc = B.next();
                        found = false;
                        for (int i = 0; i < C.length; i++)
                        {
                            found = C[i].search(acc);
                            if (found) 
                            {
                                C[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 5:
                        System.out.println("Good Bye..");
                        break;
                }
            }
            while (ch != 5);
        
        B.close();
        }
    }
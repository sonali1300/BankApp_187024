import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;

    public Main() {
        if (isr == null)
            isr = new InputStreamReader(System.in);
        if (buff == null)
            buff = new BufferedReader(isr);
    }


    int selectedBank, selectedOperation;
    float cash;
    String loanType;

    HashMap<Customer, >
    public static void main(String[] args) {
        Main obj = new Main();
        RBI rbi = null;

        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n");

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (obj.selectedBank) {
            case 1:
                rbi = new ICICI();
                break;

            case 2:
                rbi = new HDFC();
                break;

            case 3:
                rbi = new SBI();
                break;

            case 4:
                rbi = new AXIS();
                break;

            default:
                System.out.println("Invalid Input. Enter input from 1 to 4");


        }

        System.out.println("Customer Selected " + obj.selectedBank);
        /*System.out.println("Select your choice\n1. Deposit\n2. Withdrawal\n3. OpenFD\n4. Apply Loan\n5. Apply CC");

        try {
            obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedOperation);*/

        String choice = "";
        System.out.println("Write yes to continue and no to leave the application");
        try {
            choice = obj.buff.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (choice.equals("yes")){
            String running = "";
            do {
                System.out.println("Select your choice\n1. Deposit\n2. Withdrawal\n3. OpenFD\n4. Apply Loan\n5. Apply CC\n6. Check account balance");

                try {
                    obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (obj.selectedOperation == 1) {
                    try {
                        System.out.println("Enter the amount");
                        obj.cash = Float.parseFloat(obj.buff.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    rbi.depositMoney(obj.cash);
                }

                if (obj.selectedOperation == 2) {
                    try {
                        System.out.println("Enter the amount");
                        obj.cash = Float.parseFloat(obj.buff.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    rbi.withdrawMoney(obj.cash);
                }

                if (obj.selectedOperation == 3) {
                    try {
                        System.out.println("Enter the amount");
                        obj.cash = Float.parseFloat(obj.buff.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    rbi.openFD(obj.cash, 6, 10);
                }

                if (obj.selectedOperation == 4) {
                    try {
                        System.out.println("Enter the amount of loan wanted");
                        obj.cash = Float.parseFloat(obj.buff.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        System.out.println("Enter the type of loan wanted");
                        obj.loanType = obj.buff.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    rbi.applyLoan(obj.loanType, obj.cash, 10);
                }

                if (obj.selectedOperation == 5) {
                    rbi.applyCreditCard();
                }

                if (obj.selectedOperation == 6) {
                    rbi.getBalance();
                }

                System.out.println("If you want to keep choosing different operations, press q");
                try {
                    running = obj.buff.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } while (running.equals("q"));
            System.out.println("Write yes to continue and no to leave the application");
            try {
                choice = obj.buff.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
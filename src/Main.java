import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;

    HashMap<Integer, ArrayList<Customer>> customerData = new HashMap<>();
    HashMap<String, ArrayList<Integer>> customerBanks = new HashMap<>();

    public Main() {
        if (isr == null)
            isr = new InputStreamReader(System.in);
        if (buff == null)
            buff = new BufferedReader(isr);
    }


    int selectedBank, selectedOperation;
    float cash;
    String loanType;





    public static void main(String[] args) {
        Main obj = new Main();
        RBI rbi = null;

        while(true) {
            //String Aadhar = "";
            Customer customer = new Customer();

            System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n");

            try {
                obj.selectedBank = Integer.parseInt(obj.buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            String a = "";
            System.out.println("Enter your Aadhar number :");
            try {
                a = obj.buff.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            customer.setCustomerAadhar(a);

            String b = "";
            System.out.println("Enter your name :");
            try {
                b = obj.buff.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            customer.setCustomerName(b);


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

            String choice = "";
            System.out.println("Write yes to continue and no to leave the application");
            try {
                choice = obj.buff.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (choice.equals("yes")) {
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

                    System.out.println("If you want to keep choosing different operations, press y else, press n");
                    try {
                        running = obj.buff.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } while (running.equals("y"));
                System.out.println("Write yes to continue and no to leave the application");
                try {
                    choice = obj.buff.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(choice.equals("no"))
                    break;
            }

            if (obj.customerData.containsKey(obj.selectedBank)) {
                obj.customerData.get(obj.selectedBank).add(customer);
            } else {
                ArrayList<Customer> cus = new ArrayList<>();
                cus.add(customer);
                obj.customerData.put(obj.selectedBank, cus);
            }

            if (obj.customerBanks.containsKey(customer.customerAadhar)) {
                obj.customerBanks.get(customer.customerAadhar).add(obj.selectedBank);
            } else {
                ArrayList<Integer> bankList = new ArrayList<>();
                bankList.add(obj.selectedBank);
                obj.customerBanks.put(customer.customerAadhar, bankList);
            }

            String exit = "";
            System.out.println("Enter exit to exit the app :");
            try {
                exit = obj.buff.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (exit.equals("exit"))
                break;
        }

        System.out.println("Enter Bank number to see the number of customers : ");
        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(obj.customerData.get(obj.selectedBank).size());

        System.out.println("Enter your Aadhar number to see the number of banks : ");
        String aadhar = "";
        try {
            aadhar = obj.buff.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(obj.customerBanks.get(aadhar).size());


    }
}
public class AXIS implements RBI
{
    float balance = 1000.0f;
    float maturityAmount = 0.0f;
    float loanAmount = 0.0f;
    int count = 0;

    float ROI;

    {
        ROI = 7;
    }

    Customer customer = new Customer();
    public void depositMoney(float cash)
    {

        customer.balance += cash;
        System.out.println("Updated balance is : " + customer.balance);

    }
    public void withdrawMoney(float cash)
    {
        count++;

        if(count > 3)
        {
            cash += (0.05f * cash);
            //customer.balance -=cash;
        }

        if((customer.balance - cash) < this.balance)
        {
            System.out.println("Minimum balance reached");
        }
        else {
            customer.balance -= cash;
        }
        System.out.println("Balance in account : " + customer.balance);
    }
    public void openFD(float cash, float ROI, int years)
    {
        this.maturityAmount = ((cash * ROI * years)/100);
        cash += maturityAmount;
        System.out.println("The final amount after maturity will be : " + cash);
        customer.balance += cash;
        System.out.println("Total customer balance is : " + customer.balance);
    }
    public void applyLoan(String loanType, float cash, int years)
    {
        if(customer.balance < 5000)
        {
            System.out.println("Customer not eligible for loan");
            return;
        }

        if(loanType.equals("Education")){
            ROI = 3;
        }else if(loanType.equals("Home")){
            ROI = 4;
        }else if(loanType.equals("Personal")){
            ROI = 5;
        }else{
            ROI = 8;
        }

        this.loanAmount = ((cash * ROI * years)/100);
        cash += loanAmount;
        System.out.println("Loan amount for the customer is : " + cash);

    }
    public void applyCreditCard()
    {
        if(customer.balance < (2 * this.balance))
        {
            System.out.println("Customer not eligible for credit card \n Choose some other function to perform");

        }
        else
        {
            System.out.println("Customer eligible for Credit Card services");
        }
    }
    public void getBalance() {
        System.out.println("Account balance is :" + customer.balance);
    }

}

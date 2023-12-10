public interface RBI {
    float balance = 1000.0f;
    float maturityAmount = 0.0f;
    float loanAmount = 0.0f;
    int count = 0;
    //Customer customer = new Customer();

    public void depositMoney(float cash);

    public void withdrawMoney(float cash);

    public void openFD(float cash, float ROI, int years);

    public void applyLoan(String loanType, float cash, int years);

    public void applyCreditCard();
    public void getBalance();
}
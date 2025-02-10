public class SavingAccount implements Account{
    private String accountNumber;
    private String username;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private double balance;

    public SavingAccount(String accountNumber, String username, String dateOfBirth, String gender, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Receive : \t\t\t\t\t$"+amount);
        System.out.println("Total Balance : \t\t\t\t$"+amount);
    }

    @Override
    public void withdraw(double amount) {
        double maxWithdrawableAmount = balance * 0.8;

        if (amount > maxWithdrawableAmount) {
            System.out.println("\u001B[31mError: You can only withdraw up to 80% of the total balance.\u001B[0m");
        } else if (amount <= 0) {
            System.out.println("\u001B[31mError: Withdrawal amount must be greater than zero.\u001B[0m");
        } else {
            balance = balance - amount;
            System.out.println("Withdraw : \t\t\t\t$" + amount);
            System.out.println("Total Balance : \t\t$" + balance);
            System.out.println("=============================================");
            System.out.println("\u001B[32mwithdraw Money Successfully\u001B[0m ");
        }
    }

    @Override
    public void transfer(double amount, Account targetAccount) {

    }


    @Override
    public void displayAccountInfo() {
        System.out.println("\u001B[34m>>>>>>> Saving Account Information <<<<<<<\u001B[0m");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Username: " + username);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Balance: " + balance+" $");
        System.out.println("=======================================================\n");
    }
}

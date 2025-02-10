public class CheckingAccount implements Account{
    private String accountNumber;
    private String username;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private double balance;

    public CheckingAccount(String accountNumber, String username, String dateOfBirth, String gender, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Receive : \t\t\t\t$"+amount);
        System.out.println("Total Balance : \t\t\t$"+balance);
    }

    @Override
    public void withdraw(double amount) {
        if(amount>0 && amount<=balance){
            balance = balance - amount;
            System.out.println("Withdraw : \t\t\t\t$"+amount);
            System.out.println("Total Balance : \t\t$"+balance);
        }else{
            System.out.println("\u001B[31mYour withdraw must be greather than 0 and smaller than balance.\u001B[0m");
        }

    }

    @Override
    public void transfer(double amount, Account targetAccount) {

    }



    @Override
    public void displayAccountInfo() {
        System.out.println("\u001B[34m>>>>>>> Checking Account Information <<<<<<\u001B[0m");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Username: " + username);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Balance: " + balance+" $");
        System.out.println("=======================================================\n");
    }
}

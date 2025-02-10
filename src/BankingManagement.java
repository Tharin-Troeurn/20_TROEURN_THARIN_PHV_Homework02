import java.util.Random;
import java.util.Scanner;

public class BankingManagement {

    Scanner sc = new Scanner(System.in);
    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;

    public void start(){
        String chooseOp;
        do{
            displayMenu();
            chooseOp = sc.nextLine();
            switch (chooseOp){
                case "1":
                    createAccount();
                    break;
                case "2":
                    deposit();
                    break;
                case "3":
                    withdraw();
                    break;
                case "4":
                    transferMoney();
                    break;
                case "5":
                    displayAccountInfo();
                    break;
                case "6":
                    System.out.println("case6: Delete Account");
                    break;
                case "7":
                    System.out.println("Goodbye ...!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choose Option !!");
            }

        }while (!chooseOp.equals("0"));
    }

    public void displayMenu() {
        System.out.println("\u001B[34m================== Online Banking System ==================\u001B[0m");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Display Account Information");
        System.out.println("6. Delete Account");
        System.out.println("7. Exit");
        System.out.println("-----------------------------------------------------------");
        System.out.print("=> Choose option (1-7): ");
    }

    public void createAccount() {
        System.out.println("\u001B[34m>>>>>>>>>>>>>>>> Creating Account <<<<<<<<<<<<<<<<\u001B[0m");
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Back");
        System.out.print("What type of account do you want to create? : ");
        String chooseTypeAcc = sc.nextLine();
        String username;
        String dateOfBirth;
        String gender;
        String phoneNumber;
        if (chooseTypeAcc.equals("1") && checkingAccount != null) {
            System.out.println("\u001B[31mYou already have a Checking Account.\u001B[0m");
            return;
        } else if (chooseTypeAcc.equals("2") && savingAccount != null) {
            System.out.println("\u001B[31mYou already have a Saving Account.\u001B[0m");
            return;
        }
        while (true){
            System.out.print("Enter username: ");
            username = sc.nextLine();
            if(username.matches("^[a-z A-Z]+$")){
                break;
            }else {
                System.out.println("\u001B[31mYou can input username only a-z and A-Z.\u001B[0m ");
            }
        }
        System.out.print("Enter date of birth (dd-mm-yyyy): ");
        dateOfBirth = sc.nextLine();
        while (true){
            System.out.print("Enter gender: ");
            gender = sc.nextLine();
            if(gender.matches("^[a-z A-Z]+$")){
                break;
            }else{
                System.out.println("\u001B[31mYou can input gender only character.\u001B[0m ");
            }
        }
        while (true){
            System.out.print("Enter phone number: ");
            phoneNumber = sc.nextLine();
            if(phoneNumber.matches("^[0-9]+$")){
                break;
            }else{
                System.out.println("\u001B[31mYou can input phone number only number.\u001B[0m ");
            }
        }
        Random random = new Random();
        int min=1;  int max=999999999;
        int accountNumber = random.nextInt(max - min + 1)+min;

        if (chooseTypeAcc.equals("1")){
            checkingAccount = new CheckingAccount(String.valueOf(accountNumber), username, dateOfBirth, gender, phoneNumber);
            System.out.println("\u001B[32m=> => Your Checking Account has been created successfully.\u001B[0m ");
        } else if (chooseTypeAcc.equals("2")){

            savingAccount= new SavingAccount(String.valueOf(accountNumber), username, dateOfBirth, gender, phoneNumber);
            System.out.println("\u001B[32m=> => Your Saving Account has been created successfully.\u001B[0m ");
        } else if(chooseTypeAcc.equals("3")) {
            return;
        } else {
            System.out.println("\u001B[31mInvalid option. Please choose again.\u001B[0m");
        }
    }

    public void displayAccountInfo(){
        if (checkingAccount != null) {
            checkingAccount.displayAccountInfo();
        }
        if (savingAccount != null) {
            savingAccount.displayAccountInfo();
        }
    }

    public void deposit() {
        String chooseTypeAcc;
        System.out.println("\u001B[34m>>>>>>>>>>>>>>>> Deposit Money <<<<<<<<<<<<<<<<\u001B[0m");
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Back");

        System.out.print("What type of account do you want to Deposit Money? : ");
        chooseTypeAcc = sc.nextLine();
        String amount;


        if(chooseTypeAcc.equals("1")){
            if(checkingAccount != null){
                while (true){
                    System.out.print("Enter money to deposit: ");
                    amount = sc.nextLine();
                    if(amount.matches("^[0-9]+$")){
                        break;
                    }else {
                        System.out.println("\u001B[31mYou can input money for deposit only number.\u001B[0m ");
                    }
                }
                System.out.println("\n\t\t Checking Account\n");
                checkingAccount.deposit(Double.parseDouble(amount));
                System.out.println("=============================================");
                System.out.println("\u001B[32mDeposit Money Successfully\u001B[0m \n\n");
            }else{
                System.out.println("\u001B[31mYou don't have Checking account\u001B[0m");
            }

        } else if (chooseTypeAcc.equals("2")){
            if(savingAccount != null){
                while (true){
                    System.out.print("Enter money to deposit: ");
                    amount = sc.nextLine();
                    if(amount.matches("^[0-9]+$")){
                        break;
                    }else {
                        System.out.println("\u001B[31mYou can input money for deposit only number.\u001B[0m ");
                    }
                }
                System.out.println("\n\t\t Saving Account");
                savingAccount.deposit(Double.parseDouble(amount));
                System.out.println("=============================================");
                System.out.println("\u001B[32mDeposit Money Successfully\u001B[0m ");
            }else {
                System.out.println("\u001B[31mYou don't have Saving account\u001B[0m");
            }
        } else if (chooseTypeAcc.equals("3")) {
            return;
        }else{
            System.out.println("\u001B[31mInvalid option. Please choose again.\u001B[0m");
        }

    }

    public void withdraw() {
        String chooseTypeAcc;
        String withdrawMoney;
        System.out.println("\u001B[34m>>>>>>>>>>>>>>>> Withdraw Money <<<<<<<<<<<<<<<<\u001B[0m");
        System.out.println("1. Checking Account");
        System.out.println("2. Saving Account");
        System.out.println("3. Back");

        System.out.print("What type of account do you want to Withdraw Money? : ");
        chooseTypeAcc = sc.nextLine();
        if(chooseTypeAcc.equals("1")){
            if(checkingAccount != null){
                while (true){
                    System.out.print("Enter money to withdraw: ");
                    withdrawMoney = sc.nextLine();
                    if(withdrawMoney.matches("^[0-9]+$")){
                        break;
                    }else {
                        System.out.println("\u001B[31mYou can input money for withdraw only number.\u001B[0m ");
                    }
                }
                System.out.println("\n\t\t Checking Account\n");
                checkingAccount.withdraw(Double.parseDouble(withdrawMoney));
                System.out.println("=============================================");
                System.out.println("\u001B[32mwithdraw Money Successfully\u001B[0m \n\n");
            }
        }else if (chooseTypeAcc.equals("2")){
            if(savingAccount != null){
                while (true){
                    System.out.print("Enter money to withdraw: ");
                    withdrawMoney = sc.nextLine();
                    if(withdrawMoney.matches("^[0-9]+$")){
                        break;
                    }else {
                        System.out.println("\u001B[31mYou can input money for withdraw only number.\u001B[0m ");
                    }
                }

                System.out.println("\n\t\t Saving Account");
                savingAccount.withdraw(Double.parseDouble(withdrawMoney));

            }else {
                System.out.println("\u001B[31mYou don't have Saving account\u001B[0m");
            }
        } else if (chooseTypeAcc.equals("3")) {
            return;
        }else{
            System.out.println("\u001B[31mInvalid option. Please choose again.\u001B[0m");
        }

    }

    public void transferMoney(){
        String transferAmountStr;
        System.out.println("\u001B[34m>>>>>>>>>>>>>>>> Transfer Money <<<<<<<<<<<<<<<<\u001B[0m");
        System.out.println("1. Checking Account -> Saving Account");
        System.out.println("2. Saving Account -> Checking Account");
        System.out.println("3. Back");
        System.out.print("Choose an option: ");
        String chooseTypeAcc = sc.nextLine();
        if (checkingAccount == null || savingAccount == null) {
            System.out.println("\u001B[31mBoth accounts must exist to perform a transfer.\u001B[0m");
            return;
        }
        if(chooseTypeAcc.equals("1")){
            System.out.print("Enter money to transfer: ");
            transferAmountStr = sc.nextLine();

//            checkingAccount.transfer(Double.parseDouble(transferAmountStr),);


        }else if (chooseTypeAcc.equals("2")){

        }else if (chooseTypeAcc.equals("3")) {
            return;
        }else{
            System.out.println("\u001B[31mInvalid option. Please choose again.\u001B[0m");
        }
    }

}

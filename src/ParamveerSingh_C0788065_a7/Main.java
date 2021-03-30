package ParamveerSingh_C0788065_a7;

import javax.swing.*;
import java.io.IOException;

import static java.lang.Double.isNaN;

public class Main {
    public static void main(String[] args){
        try {
            BankAccount account;
            int input = JOptionPane.showConfirmDialog(null, "Do you have an account in the Bank? \n" +
                    "\nIf no, click on \"No\" to create a new account.");
            if(input == JOptionPane.NO_OPTION){
                account = openNewAccount();
            }else if(input == JOptionPane.YES_OPTION){
                account = new BankAccount(getAccountNo());
            }else{
                return;
            }

            if(account.getDetails().length > 4 ) {
                JOptionPane.showMessageDialog(null, "Please enter valid account number: ");

            } else {
                while(true) {
                    String output = "Name: " + account.getDetails()[0] + "\nAccount number: " + account.getAccountNo();
                    output += "\nBalance: " + account.getDetails()[1];
                    String option = JOptionPane.showInputDialog(output + "\nActions: " +
                            "\nEnter 1 to deposit money" +
                            "\nEnter 2 to withdraw money" +
                            "\nEnter 3 to check balance" +
                            "\nEnter 4 to sign out").trim();
                    double amount = 0;

                    switch (option) {
                        case "1":
                            try {
                                amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount:").trim());
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Please enter valid amount.");
                                continue;
                            }

                            if (isNaN(amount) || amount <= 0) {
                                JOptionPane.showMessageDialog(null, "Please enter valid amount.");
                                continue;
                            }
                            break;

                        case "2":
                            try {
                                amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount:").trim());
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Please enter valid amount.");
                                continue;
                            }

                            if (isNaN(amount) || amount <= 0) {
                                JOptionPane.showMessageDialog(null, "Please enter valid amount.");
                                continue;
                            }
                            amount = -amount;
                            break;

                        case "3":
                            break;

                        case "4":
                            System.exit(0);

                        default:
                            JOptionPane.showMessageDialog(null, "Please select any number from menu");
                    }

                    account.processTransaction(new Transaction(amount));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("Exception occurred.");
        }
    }

    /**
     *
     * @return account number or name of the account file without .txt extension
     */
    public static String getAccountNo(){
        return JOptionPane.showInputDialog("Enter your account number: ");
    }

    /**
     *
     * @return BankAccount object having account number equal to newly created account
     */
    public static BankAccount openNewAccount() throws IOException {
        String name = JOptionPane.showInputDialog("Enter your name: ").trim();
        return BankAccount.open(name);
    }
}

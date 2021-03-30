package ParamveerSingh_C0788065_a7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BankAccount {
    private String accountNo;

    public BankAccount(){
        this.accountNo = "";
    }

    /**
     * @param accountNo for existing account Number,
     * if the user has account, then the overloaded constructor will be used
     */
    public BankAccount(String accountNo){
        this();
        this.accountNo = accountNo;
    }

    public String getAccountNo(){
        return this.accountNo;
    }

    /**
     * @param name for the name of the user to open account
     * @return Bank Account object having new random account number
     * @throws IOException if the file not found or unable to write to the file...IOException is thrown
     */

    public static BankAccount open(String name) throws IOException {
        String randomId = (int) (Math.random() * 10000)+"";
        while(true){
            if(!accountExists(randomId)){
                File file = new File(randomId+".txt");
                FileWriter writer = new FileWriter(file);
                writer.write(name+"-"+0);
                writer.close();

                return new BankAccount(randomId);
            }
            randomId = (int) (Math.random() * 10000)+"";
        }
    }

    /**
     *
     * @return String array of length 2 or 0...2 for valid account and 0 if account does not exist
     * @throws FileNotFoundException if the account does not exists
     */
    public String[] getDetails() throws FileNotFoundException {
        String[] details = {};
        if(accountExists(this.accountNo)){
            File file = new File(this.accountNo+".txt");
            Scanner reader = new Scanner(file);
            String data = "";
            while (reader.hasNextLine()) {
                data = reader.nextLine().trim();
                if(!data.equals(""))
                    break;
            }
            details = data.split("-");
        }

        return details;
    }

    /*
     * @param transaction transaction has the amount to withdraw or deposit
     */

    public void processTransaction(Transaction transaction) throws IOException {
        String[] details = getDetails();
        String name = details[0];
        double balance = Double.parseDouble(details[1]);

        double updatedBalance = balance + transaction.getAmount();

        if(updatedBalance < 0){
            System.out.println("Insufficient Balance!");
            return ;
        }

        File file = new File(this.accountNo+".txt");
        FileWriter writer = new FileWriter(file, false);
        writer.write(name+"-"+updatedBalance);
        writer.close();
    }

    /**
     * @param accountNo name of the file without .txt extension
     * @return true if the account exists, false otherwise
     */

    public static boolean accountExists(String accountNo){
        return new File(accountNo + ".txt").exists();
    }
}

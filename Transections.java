package CaseStudy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Transections {
	private static int transCounter = 0; 
	private int transID;
	private int accNumber;
	private String accType;
    private double amount;
    protected Date timestamp;
    
    private static List<Transections> allTransactions = new ArrayList<>();
    
    Transections(int accountNumber, String accountType, double amount) {
    	this.transID = ++transCounter;
        this.accNumber = accountNumber;
        this.accType=accountType;
        this.amount = amount;
        this.timestamp = new Date(); // Current
        // Add this transaction to the static list
        allTransactions.add(this);
    }
    
    public static List<Transections> getAllTransactions() {
        return allTransactions;
    }
    
    public int getTransID() {
		return transID;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public String getAccType() {
		return accType;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public double getAmount() {
        return amount;
    }
    
    public void displayTransection(){
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String timestamp2 = simpleDateFormat.format(this.timestamp); 
    	System.out.println("| "+ this.transID +" | "+ timestamp2 +" | "+ this.accNumber +" | "+ this.accType +" | "+ this.amount +" |");    
    } 
    
    
 // Method to display daily transactions
    public static void displayDailyTransactions(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Daily Transactions for " + dateFormat2.format(date) + ":");
        boolean found = false;
        for (Transections transaction : allTransactions) {
            if (isSameDay(transaction.getTimestamp(), date)) {
                found = true;
                System.out.println("| "+ transaction.getTransID() +" | "+ dateFormat.format(transaction.getTimestamp()) +" | "+ transaction.getAccNumber() +" | "+ transaction.getAccType() +" | "+ transaction.getAmount() +" |");
            }
        }
        if (!found) {
            System.out.println("No transactions found for " + dateFormat2.format(date));
        }
    }

    private static boolean isSameDay(Date date1, Date date2) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
    	String strDate = dateFormat.format(date1); 
    	String strDate1 = dateFormat.format(date2);
        return strDate.equals(strDate1);
    }

}



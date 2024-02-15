package CaseStudy;

import java.util.ArrayList;
import java.util.List;

abstract class Account {
    private int accNo;    // long datatype Prefered 
    private String accHolderName;
    private String accType;
    private double balance;
    private static List<Account> allAccount = new ArrayList<>();

    // Constructor
    public Account(int accNo, String accHolderName, String accType, double balance) {
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.accType = accType;
        this.balance = balance;
        allAccount.add(this);
    }

    // Setters
    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getters
    public int getAccNo() {
        return accNo;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public String getAccType() {
        return accType;
    }

    public double getBalance() {
        return balance;
    }
    
    public static void allAccountDetails() {
		// TODO Auto-generated method stub
    	if(allAccount.isEmpty()) {
    		System.out.println("No Data Found.");
    	}
    	else {
	    	System.out.println("All Account Data");
	    	System.out.println("-----------------------------");
	    	for (Account account : allAccount) {
	    		System.out.println("| "+ account.getAccNo() +" | "+ account.getAccHolderName() +" | "+ account.getAccType() +" | "+ account.getBalance()+" |");   
	    	}
    	}
    }
    
    public static void deleteAccount(int accNo) {
    	int flag=0;
    	for (Account account : allAccount) {
    		if(account.accNo == accNo) {
    			
    			allAccount.remove(account);
    			flag++;
    			break;
    		}
    	}
    	if(flag==0) {
    		System.out.println("Account Not Found");
    	}
    	
    }

    //Behaviours / Methods
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void calcInterest(); 
    public abstract void checkBalance();
    public abstract void displayDetails();
    public abstract void displayAllTransactions();// show All transection of perticular account
    public abstract List<Transections> getAllTransactions(); //return list All transection of perticular account
}

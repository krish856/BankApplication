package CaseStudy;
import java.util.ArrayList;
import java.util.List;
public class SavingAccount extends Account{

     public static double interestRate=0.7;
     public double minAmountRequired=10000;
     private List<Transections> transactions;

     // Constructor
     public SavingAccount(int accNo, String accHolderName, double balance) {
    	 super(accNo, accHolderName, "Saving Account" ,balance);
    	 this.transactions = new ArrayList<>();
    	 Transections transaction = new Transections(accNo, "Saving", balance);
         transactions.add(transaction);
     }

// Setters
     public void setInterestRate(double interestRate) {
    	 SavingAccount.interestRate = interestRate;
     }

// Getters
     public double getInterestRate() {
    	 return interestRate;
     }

     @Override
     public void deposit(double amount) {
    	 this.setBalance(this.getBalance() + amount);
    	 Transections transaction = new Transections(this.getAccNo(), "Saving", amount);
         transactions.add(transaction);
         System.out.println("Successfully Deposited");
     }

     @Override
     public void withdraw(double amount) {
         if((this.getBalance() - amount) >= minAmountRequired){
        	 this.setBalance(this.getBalance() - amount);
        	 Transections transaction = new Transections(this.getAccNo(), "Saving", -amount);
             transactions.add(transaction);
             System.out.println("Successfully Withdraw");
         }
         else{
             System.out.println("Insufficient Balance, Bcz Minimum balance of 10000 Rs. must be maintained in saving account");
         }
     }

     @Override
     public void calcInterest() {
         System.out.println(SavingAccount.interestRate);
     } 
     
     public void dispalyData() {
    	 System.out.println("| "+ this.getAccNo() +" | "+ this.getAccHolderName() +" | "+ this.getAccType() +" | "+ this.getAccType() +" | "+ this.getBalance()+" |");   
     }
     
  // Function to get transactions
     public List<Transections> getAllTransactions() {
         List<Transections> AllTransactions = new ArrayList<>();
         for (Transections transaction : transactions) {
        	 AllTransactions.add(transaction);
         }
         return AllTransactions;
     }
     
	public void displayAllTransactions() {
        List<Transections> AllTransactions = getAllTransactions();
        if (AllTransactions.isEmpty()) {
            System.out.println("No transactions found ");
        } else {
            System.out.println("All Transactions of AccountNo: " + this.getAccNo() + ":");
            for (Transections transaction : AllTransactions) {
                transaction.displayTransection();
            }
        }
    }

	@Override
	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("Balance: "+this.getBalance());
	}

	@Override
	public void displayDetails() {
		// TODO Auto-generated method stub
		 System.out.println("| "+ this.getAccNo() +" | "+ this.getAccHolderName() +" | "+ this.getAccType() +" | "+ this.getBalance()+" |");   
    }
	
	
}


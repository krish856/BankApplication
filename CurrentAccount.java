package CaseStudy;
import java.util.ArrayList;
import java.util.List;
public class CurrentAccount extends Account {
	public static double interestRate=0.7;
    public double maxLimit=2000;
    private List<Transections> transactions;

    // Constructor
    CurrentAccount(int accNo, String accHolderName, double balance) {
        super(accNo, accHolderName, "Current Account" ,balance);
        this.transactions = new ArrayList<>();
   	 	Transections transaction = new Transections(accNo, "Current", balance);
        transactions.add(transaction);
    }

    // Setters
    public void setInterestRate(double interestRate) {
        CurrentAccount.interestRate = interestRate;
    }

    // Getters
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void deposit(double amount) {
    	this.setBalance(this.getBalance() + amount);
    	Transections transaction = new Transections(this.getAccNo(), "Current", amount);
        transactions.add(transaction);
        System.out.println("Successfully Deposited");
    }

    @Override
    public void withdraw(double amount) {
        if(this.getBalance() >= amount){
            if((amount <= maxLimit)){
            	this.setBalance(this.getBalance() - amount);
            	Transections transaction = new Transections(this.getAccNo(), "Current", -amount);
                transactions.add(transaction);
                System.out.println("Successfully Withdraw");
            }
            else{
                System.out.println("Withdraw limit is "+ maxLimit+ "so you can't withdraw.");
            }
        }
        else{
            System.out.println("Insufficient Balance");
        }
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
    public void calcInterest() {
        System.out.println(CurrentAccount.interestRate);
    }

	@Override
	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("Balance: "+this.getBalance());
	}

	@Override
	public void displayDetails() {
		// TODO Auto-generated method stub
		 System.out.println("| "+ this.getAccNo() +" | "+ this.getAccHolderName() +" | "+ this.getAccType() +" | "+ this.getAccType() +" | "+ this.getBalance()+" |");   
    }
}



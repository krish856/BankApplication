package CaseStudy;
import java.util.ArrayList;
import java.util.List;
public class LoanAccount extends Account{
    public static double interestRate=0.9;
    private double loanAmount;
    private double amountRepaid;
    private List<Transections> transactions;

    // Constructor
    LoanAccount(int accNo, String accHolderName, double loanAmount) {
        super(accNo, accHolderName, "Loan Account" ,-loanAmount); // Initial balance is negative (loan amount)
        this.transactions = new ArrayList<>();
   	 	Transections transaction = new Transections(accNo, "Loan", loanAmount);
        transactions.add(transaction);
        this.loanAmount = loanAmount;
        this.amountRepaid = 0;
    }
    
    // Setters
    public void setInterestRate(double interestRate) {
        LoanAccount.interestRate = interestRate;
    }

    // Getters
    public double getInterestRate() {
        return interestRate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getAmountRepaid() {
        return amountRepaid;
    }

    @Override
    public void deposit(double amount) {
    	this.setBalance(this.getBalance() + amount);
    	Transections transaction = new Transections(this.getAccNo(), "Loan", amount);
        transactions.add(transaction);
        System.out.println("Successfully Deposited");
    }

    @Override
    public void withdraw(double amount) {
        if(this.getBalance() >= amount){
        	this.setBalance(this.getBalance() - amount);
        	Transections transaction = new Transections(this.getAccNo(), "Loan", +amount);
            transactions.add(transaction);
            System.out.println("Successfully Withdraw");
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

    @Override
    public void calcInterest() {
        System.out.println(LoanAccount.interestRate);
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

    // Method to record loan repayment
    public void repayLoan(double amount) {
        if (amount <= loanAmount*(1+interestRate) - amountRepaid) {
            amountRepaid += amount;
            
            deposit(amount); // Deposit the repayment amount into the loan account
        } else {
            System.out.println("Cannot repay more than the outstanding loan amount.");
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
		 System.out.println("| "+ this.getAccNo() +" | "+ this.getAccHolderName() +" | "+ this.getAccType() +" | "+ this.getAccType() +" | "+ this.getBalance()+" |");   
    }
}

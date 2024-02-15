package CaseStudy;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
public class SalaryAccount extends Account{
    public static double interestRate=0.6;
    public static double minAmountRequired=10000;
    private LocalDate PrevDate;
    private List<Transections> transactions;

    // Constructor
    SalaryAccount(int accNo, String accHolderName, double balance) {
        super(accNo, accHolderName, "Salary Account" ,balance);
        this.transactions = new ArrayList<>();
   	 	Transections transaction = new Transections(accNo, "Salary", balance);
        transactions.add(transaction);
    }

    // Setters
    public void setInterestRate(double interestRate) {
        SalaryAccount.interestRate = interestRate;
    }

    // Getters
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void deposit(double amount) {
        Period temp=Period.between(PrevDate, LocalDate.now());
        if(temp.getMonths() <= 2){
        	this.setBalance(this.getBalance() + amount);
            PrevDate= LocalDate.now();
            Transections transaction = new Transections(this.getAccNo(), "Salary", amount);
            transactions.add(transaction);
            System.out.println("Successfully Deposited");
        }
        else{
            System.out.println("Your Account Blocked.");
        }
    }

    @Override
    public void withdraw(double amount) {
        Period temp=Period.between(PrevDate, LocalDate.now());
        if(temp.getMonths() <= 2){
            if((this.getBalance() - amount) >= minAmountRequired){
            	this.setBalance(this.getBalance() - amount);
                PrevDate= LocalDate.now();
                Transections transaction = new Transections(this.getAccNo(), "Salary", -amount);
                transactions.add(transaction);
                System.out.println("Successfully Withdraw");
            }
            else{
                System.out.println("Insufficient Balance, Bcz Minimum balance of 10000 Rs. must be maintained in salary account");
            }
        }
        else{
            System.out.println("Your Account Blocked.");
        }
    }

    @Override
    public void calcInterest() {
        System.out.println(SalaryAccount.interestRate);
    }  
    
    public void dispalyData() {
   	 System.out.println("| "+ this.getAccNo() +" | "+ this.getAccHolderName() +" | "+ this.getAccType() +" | "+ this.getAccType() +" | "+ this.getBalance()+" |");   
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

	@Override
	//Function to get transactions
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
}

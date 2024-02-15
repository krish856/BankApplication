package CaseStudy;

import java.util.Date;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		 @SuppressWarnings("resource")
		 Scanner sc = new Scanner(System.in);
		 int indx1=0, indx2=0, indx3=0, indx4=0;
		 int subChoice;
		 int flag=0;
		 
		 SavingAccount savingAccount[]=new SavingAccount[100];
		 SalaryAccount salaryAccount[]=new SalaryAccount[100];
		 CurrentAccount currentAccount[]=new CurrentAccount[100];
		 LoanAccount loanAccount[]=new LoanAccount[100];
		
	     while (true) {
	       System.out.println();
      	   System.out.println("-----------------------------------------------------");
           System.out.println("|         Bank Daily Activities Menu                |");
           System.out.println("-----------------------------------------------------");
           System.out.println("|  1. Create Account                                |");
           System.out.println("|  2. Deposit                                       |");
           System.out.println("|  3. Withdraw                                      |");
           System.out.println("|  4. Display all transection of Perticular Account |");
           System.out.println("|  5. Display all Daily Transactions                |");
           System.out.println("|  6. Display all Account created in Bank           |");
           System.out.println("|  7. Display Details of Account                    |");
           System.out.println("|  8. Exit                                          |");
           System.out.println("-----------------------------------------------------");
           System.out.print("Enter your choice: ");
           int choice = sc.nextInt();
           
           
           switch (choice) {
               case 1:
              	   System.out.println("------------------------------------------------");
              	   System.out.println("|  1. Create Saving Account                    |");
                   System.out.println("|  2. Create Salary Account                    |");
                   System.out.println("|  3. Create Current Account                   |");
                   System.out.println("|  4. Create Loan Account                      |");
                   System.out.println("|  5. Back                                      |");
                   System.out.println("------------------------------------------------");
                   System.out.print("Enter your choice: ");
                   subChoice = sc.nextInt();
                   
                   if(subChoice==5) {
                      break; // Go back to main menu)
                   }
                 
	               System.out.println();
	               System.out.println("Enter Account No: ");
	               int tempAccNo = sc.nextInt();

	               sc.nextLine(); // Consume newline character

	               System.out.println("Enter Account Holder Name: ");
	               String tempAccHolderName = sc.nextLine();

	               System.out.println("Enter Amount: ");
	               double tempBalance = sc.nextDouble();

                   
                   switch (subChoice) {
                       case 1:
                    	   savingAccount[indx1]=new SavingAccount(tempAccNo, tempAccHolderName, tempBalance);
                    	   indx1++;
                    	   System.out.println("Successfully Saving Account Created.");
                           break;
                       case 2:
                    	   salaryAccount[indx2]=new SalaryAccount(tempAccNo, tempAccHolderName, tempBalance);
                    	   indx2++;
                    	   System.out.println("Successfully Salary Account Created.");
                           break;
                       case 3:
                    	   currentAccount[indx3]=new CurrentAccount(tempAccNo, tempAccHolderName, tempBalance);
                    	   indx3++;
                    	   System.out.println("Successfully Current Account Created.");
                           break;
                       case 4:
                    	   loanAccount[indx4]=new LoanAccount(tempAccNo, tempAccHolderName, tempBalance);
                    	   indx4++;
                    	   System.out.println("Successfully Current Account Created.");
                           break;
                       default:
                           System.out.println("Invalid choice! Please enter a valid option.");
                   }
                   break;
                   
               case 2:
            	    System.out.println("------------------------------------------------");
            	    System.out.println("|  1. Deposit to Saving Account                |");
            	    System.out.println("|  2. Deposit to Salary Account                |");
            	    System.out.println("|  3. Deposit to Current Account               |");
            	    System.out.println("|  4. Deposit to Loan Account                  |");
            	    System.out.println("|  5. Back                                     |");
            	    System.out.println("------------------------------------------------");
            	    System.out.print("Enter your choice: ");
            	    subChoice = sc.nextInt();
            	    
            	    if(subChoice==5) {
                        break; // Go back to main menu)
            	    }
            	    
            	    System.out.println();
            	    System.out.print("Enter Account No: ");
            	    int tempDepositeAccNo = sc.nextInt();
            	    
            	    switch (subChoice) {
            	        case 1:
            	            // Deposit to SavingAccount
            	        	flag=0;
            	            for (int i = 0; i < savingAccount.length; i++) {
            	                if (savingAccount[i] != null && tempDepositeAccNo == savingAccount[i].getAccNo()) {
            	                    System.out.print("Enter Deposit amount: ");
            	                    double tempDepositeAmount = sc.nextDouble();
            	                    savingAccount[i].deposit(tempDepositeAmount);
            	                    flag++;
            	                    break; // Exit loop after finding the account
            	                }
            	            }
            	            if(flag==0) {
                 			   System.out.print("Account Not Found.");
                 		   }
            	            break;
            	        case 2:
            	            // Deposit to SalaryAccount
            	        	flag=0;
            	            for (int i = 0; i < salaryAccount.length; i++) {
            	                if (salaryAccount[i] != null && tempDepositeAccNo == salaryAccount[i].getAccNo()) {
            	                    System.out.print("Enter Deposit amount: ");
            	                    double tempDepositeAmount = sc.nextDouble();
            	                    salaryAccount[i].deposit(tempDepositeAmount);
            	                    flag++;
            	                    break; // Exit loop after finding the account
            	                }
            	            }
            	            if(flag==0) {
                 			   System.out.print("Account Not Found.");
                 		   }
            	            break;
            	        case 3:
            	            // Deposit to CurrentAccount
            	        	flag=0;
            	            for (int i = 0; i < currentAccount.length; i++) {
            	                if (currentAccount[i] != null && tempDepositeAccNo == currentAccount[i].getAccNo()) {
            	                    System.out.print("Enter Deposit amount: ");
            	                    double tempDepositeAmount = sc.nextDouble();
            	                    currentAccount[i].deposit(tempDepositeAmount);
            	                    flag++;
            	                    break; // Exit loop after finding the account
            	                }
            	            }
            	            if(flag==0) {
                 			   System.out.print("Account Not Found.");
                 		   }
            	            break;
            	        case 4:
            	            // Deposit to LoanAccount
            	        	flag=0;
            	            for (int i = 0; i < loanAccount.length; i++) {
            	                if (loanAccount[i] != null && tempDepositeAccNo == loanAccount[i].getAccNo()) {
            	                    System.out.print("Enter Deposit amount: ");
            	                    double tempDepositeAmount = sc.nextDouble();
            	                    loanAccount[i].deposit(tempDepositeAmount);
            	                    flag++;
            	                    break; // Exit loop after finding the account
            	                }
            	            }
            	            if(flag==0) {
                 			   System.out.print("Account Not Found.");
                 		   }
            	            break;
            	        default:
            	            System.out.println("Invalid choice! Please enter a valid option.");
            	    }
            	    break;
                
               case 3:
            	   System.out.println("------------------------------------------------");
                   System.out.println("|  1. Withdraw from Saving Account             |");
                   System.out.println("|  2. Withdraw from Salary Account             |");
                   System.out.println("|  3. Withdraw from Current Account            |");
                   System.out.println("|  4. Withdraw from Loan Account               |");
                   System.out.println("|  5. Back                                     |");
                   System.out.println("------------------------------------------------");
                   System.out.print("Enter your choice: ");
                   subChoice = sc.nextInt();
                   
                   if(subChoice==5) {
                       break; // Go back to main menu)
                    }
                   
                   System.out.println();
                   System.out.print("Enter Account No: ");
                   int tempWithdrawAccNo=sc.nextInt();
                   switch (subChoice) {
                       case 1:
                           // Withdraw from SavingAccount
                    	   flag=0;
                    	   for(int i=0; i<savingAccount.length ;i++) {
                    		   if(savingAccount[i] != null && tempWithdrawAccNo == savingAccount[i].getAccNo()) {
                    			   System.out.print("Enter Withdraw amount: ");
                                   double tempWithdrawAmount=sc.nextDouble();
                    			   savingAccount[i].withdraw(tempWithdrawAmount);
                    			   flag++;
                    			   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                       case 2:
                           // Withdraw from SalaryAccount
                    	   flag=0;
                    	   for(int i=0; i<salaryAccount.length ;i++) {
                    		   if(salaryAccount[i] != null && tempWithdrawAccNo == salaryAccount[i].getAccNo()) {
                    			   System.out.print("Enter Withdraw amount: ");
                                   double tempWithdrawAmount=sc.nextDouble();
                    			   salaryAccount[i].withdraw(tempWithdrawAmount);
                    			   flag++;
                    			   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                    
                       case 3:
                           // Withdraw from CurrentAccount
                    	   flag=0;
                    	   for(int i=0; i<currentAccount.length ;i++) {
                    		   if(currentAccount[i] != null && tempWithdrawAccNo == currentAccount[i].getAccNo()) {
                    			   System.out.print("Enter Withdraw amount: ");
                                   double tempWithdrawAmount=sc.nextDouble();
                                   currentAccount[i].withdraw(tempWithdrawAmount);
                                   flag++;
                    			   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                        
                       case 4:
                           // Withdraw from LoanAccount
                    	   flag=0;
                    	   for(int i=0; i<loanAccount.length ;i++) {
                    		   if(loanAccount[i] != null && tempWithdrawAccNo == loanAccount[i].getAccNo()) {
                    			   System.out.print("Enter Withdraw amount: ");
                                   double tempWithdrawAmount=sc.nextDouble();
                                   loanAccount[i].withdraw(tempWithdrawAmount);
                                   flag++;
                    			   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                    
                       default:
                           System.out.println("Invalid choice! Please enter a valid option.");
                   }
                   break;
               
               case 4:
            	   System.out.println("-----------------------------------------------------");
                   System.out.println("|  1. Account type (Saving)                         |");
                   System.out.println("|  2. Account type (Salary)                         |");
                   System.out.println("|  3. Account type (Current)                        |");
                   System.out.println("|  4. Account type (Loan)                           |");
                   System.out.println("|  5. Back                                          |");
                   System.out.println("-----------------------------------------------------");
                   System.out.print("Enter your choice: ");
                   subChoice = sc.nextInt();
                   
                   if(subChoice==5) {
                       break; // Go back to main menu)
                    }
                   System.out.println();
                   System.out.print("Enter Account No: ");
                   int temptransectionAccNo=sc.nextInt();
                   switch (subChoice) {
                       case 1:
                           // Display Daily Transactions (SavingAccount)
                    	   flag=0;
                    	   for(int i=0; i<savingAccount.length ;i++) {
                    		   if(savingAccount[i]!= null && temptransectionAccNo == savingAccount[i].getAccNo()) {
                    			   savingAccount[i].displayAllTransactions();
                    			   flag++;
                    			   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                       case 2:
                           // Display Daily Transactions (SalaryAccount)
                    	   flag=0;
                    	   for(int i=0; i<salaryAccount.length ;i++) {
                    		   if(savingAccount[i]!= null && temptransectionAccNo == salaryAccount[i].getAccNo()) {
                    			   salaryAccount[i].displayAllTransactions();
                    			   flag++;
                    			   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                       case 3:
                           // Display Daily Transactions (CurrentAccount)
                    	   flag=0;
                    	   for(int i=0; i<currentAccount.length ;i++) {
                    		   if(savingAccount[i]!= null && temptransectionAccNo == currentAccount[i].getAccNo()) {
                    			   currentAccount[i].displayAllTransactions();
                    			   flag++;
                    			   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                       case 4:
                           // Display Daily Transactions (LoanAccount)
                    	   flag=0;
                    	   for(int i=0; i<loanAccount.length ;i++) {
                    		   if(savingAccount[i]!= null && temptransectionAccNo == loanAccount[i].getAccNo()) {
                                   loanAccount[i].displayAllTransactions();
                                   flag++;
                                   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                     
                       default:
                           System.out.println("Invalid choice! Please enter a valid option.");
                   }
                   break;
               
               case 5:  
            	// Display Daily Transactions (All)
            	   Transections.displayDailyTransactions(new Date());
                   break;
                   
               case 6:     
            	// Display All Account Exist in bank
                   Account.allAccountDetails();
                   break;
                   
               case 7:
            	   System.out.println("-----------------------------------------------------");
                   System.out.println("|  1. Account type (Saving)                         |");
                   System.out.println("|  2. Account type (Salary)                         |");
                   System.out.println("|  3. Account type (Current)                        |");
                   System.out.println("|  4. Account type (Loan)                           |");
                   System.out.println("|  5. Back                                          |");
                   System.out.println("-----------------------------------------------------");
                   System.out.print("Enter your choice: ");
                   subChoice = sc.nextInt();
                   
                   if(subChoice==5) {
                       break; // Go back to main menu)
                    }
                   System.out.println();
                   System.out.print("Enter Account No: ");
                   int tempDisplayDataAccNo=sc.nextInt();
                   switch (subChoice) {
                       case 1:
                           // Display Daily Transactions (SavingAccount)
                    	   flag=0;
                    	   for(int i=0; i<savingAccount.length ;i++) {
                    		   if(savingAccount[i]!= null && tempDisplayDataAccNo == savingAccount[i].getAccNo()) {
                    			   savingAccount[i].displayDetails();
                    			   flag++;
                    			   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                       case 2:
                           // Display Daily Transactions (SalaryAccount)
                    	   flag=0;
                    	   for(int i=0; i<salaryAccount.length ;i++) {
                    		   if(savingAccount[i]!= null && tempDisplayDataAccNo == salaryAccount[i].getAccNo()) {
                    			   salaryAccount[i].displayDetails();
                    			   flag++;
                    			   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                       case 3:
                           // Display Daily Transactions (CurrentAccount)
                    	   flag=0;
                    	   for(int i=0; i<currentAccount.length ;i++) {
                    		   if(savingAccount[i]!= null && tempDisplayDataAccNo == currentAccount[i].getAccNo()) {
                    			   currentAccount[i].displayDetails();
                    			   flag++;
                    			   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                       case 4:
                           // Display Daily Transactions (LoanAccount)
                    	   flag=0;
                    	   for(int i=0; i<loanAccount.length ;i++) {
                    		   if(savingAccount[i]!= null && tempDisplayDataAccNo == loanAccount[i].getAccNo()) {
                                   loanAccount[i].displayDetails();
                                   flag++;
                                   break;
                    		   }
                    	   }
                    	   if(flag==0) {
                			   System.out.print("Account Not Found.");
                		   }
                           break;
                     
                       default:
                           System.out.println("Invalid choice! Please enter a valid option.");
                   }
                   break;
            	   
               case 8:
            	   System.out.println("Exiting...");
                   System.exit(0);
                   
               default:
                   System.out.println("Invalid choice! Please enter a valid option.");
           }
       }		    
	}
}


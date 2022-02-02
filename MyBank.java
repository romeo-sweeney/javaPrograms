// Roméo Sweeney
// This program lets a user create their own bank account and perform certain types of actions.

import java.util.Scanner;

public class MyBank {
		
	
	private String accountHolderName;
	private double savingsAmt;
	private double checkingsAmt;
	
	public MyBank() {
		this.accountHolderName = "";
		this.savingsAmt = 0;
		this.checkingsAmt = 0;
	}

	public MyBank(String accountHolderName, double savingsAmt, double checkingsAmt) {
		this.accountHolderName = accountHolderName;
		this.savingsAmt = savingsAmt;
		this.checkingsAmt = checkingsAmt;
	}
	
	public void checkSavingsBal() {
		System.out.printf("You have %.2f in your savings acoount.", this.savingsAmt);
	}
	
	public void checkCheckingsBal() {
		System.out.printf("You have %.2f in your checkings account.", this.checkingsAmt);
	}
	 
	public void withdrawalSavings(double amt) {
		if (this.savingsAmt - amt > 0) {
			this.savingsAmt -= amt; 
		}else {
			System.out.println("Insufficient funds.");
		}
	}
	
	public void withdrawalCheckings(double amt) {
		if (this.checkingsAmt - amt > 0) {
			this.checkingsAmt -= amt; 
		}else {
			System.out.println("Insufficient funds.");
		}
	}
	
	private double transfer(double from, double into, double amt) {
		return into += from - amt;
	}
	
	
	public void transferSavingsToCheckings(double amt) {
		transfer(this.savingsAmt , this.checkingsAmt, amt);
	}
	
	public void transferCheckingsToSavings(double amt) {
		transfer(this.checkingsAmt , this.savingsAmt, amt);
	}
	
	public void transaction(double amt) {
		this.checkingsAmt =- amt;
	}
	
	
	public String toString() {
		return String.format("Hello, %s, your balance in your checkings and savings accounts"
				+ "is: $%.2f", this.accountHolderName, this.checkingsAmt+this.savingsAmt);
	}


	public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		
		System.out.println("Hello, please associate your name to your bank account: ");
		String accName = scr.nextLine();
		System.out.printf("Thank you, %s, please add the amount you wish to add in your savings and checkings account respectively: ", accName);
		
		double checkings = scr.nextDouble();
		double savings = scr.nextDouble();
		
		MyBank bank = new MyBank(accName, checkings, savings);

		do {
			System.out.println("Do you want to perform an action to your account?\n"
					+ "Type ctrl+d when you wish to quit MyBank.");
			
			scr.next();
			
			System.out.println("Here are your options, press the designated key to select an option:");
			System.out.println("1 - Savings Balance");
			System.out.println("2 - Checkings Balance");
			System.out.println("3 - Transfer Funds");
			System.out.println("4 - Withdraw");
			System.out.println("5 - Make a transaction");
			
			int key = scr.nextInt();
			switch (key) {
			
			case 1:
				bank.checkSavingsBal();
				break;
				
			case 2:
				bank.checkCheckingsBal();
				break;
				
			case 3:
				System.out.println("Transfer from which account? Type 'savings' or 'checkings'. Then, type the amount you wish to transfer.");
				if(scr.next() == "savings"){
					bank.transferSavingsToCheckings(scr.nextDouble());
					System.out.println("Transfer completed. Check checkings balance? Type y/n");
					if(scr.next() == "y") {
						bank.checkCheckingsBal();
						break;
					}else {
						break;
					}
				}else {
					bank.transferCheckingsToSavings(scr.nextDouble());
					System.out.println("Transfer completed. Check savings balance? Type y/n");
					if(scr.next() == "y") {
						bank.checkSavingsBal();
						break;
					}else {
						break;
					}
				}	
				
			case 4:
				System.out.println("Which account would you like to withdraw from? Type 'savings' or 'checkings'");
				if(scr.nextLine() == "savings") {
					System.out.print("Amount to be withdrawn from savings: ");
					bank.withdrawalSavings(scr.nextDouble());
					System.out.println("Withdrawal completed. Check savings balance? Type y/n");
					if(scr.next() == "y") {
						bank.checkSavingsBal();
						break;
					}else {
						break;
					}
				}else {
					System.out.print("Amount to be withdrawn from checkings: ");
					bank.withdrawalCheckings(scr.nextDouble());
					System.out.println("Withdrawal completed. Check checkings balance? Type y/n");
					if(scr.next() == "y") {
						bank.checkCheckingsBal();
						break;
					}else {
						break;
					}
				}
				
			case 5:
				System.out.print("Transaction amount: ");
				bank.transaction(scr.nextDouble());
				System.out.println("Transaction completed. Check checkings balance? Type y/n");
				if(scr.next() == "y") {
					bank.checkCheckingsBal();
					break;
				}else {
					break;
				}
				
			default: 
				System.out.println("Invalid entry. Please, try again.");
				
			System.out.println("Would you like to perform another action? Type any key to continue; otherwise, type ctrl+d.");
			}
		} while(scr.hasNext()); 
	scr.close();
	}
}

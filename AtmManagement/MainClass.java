package com.AtmManagement;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtmOperation op=new AtmOperationImpl();
int atmnumber=123456;
int atmpin=1234;
Scanner sc =new Scanner(System.in);
System.out.println("Welcome to ATM Machine");
System.out.println("Enter ATM Number:");
int atmNumber=sc.nextInt();
System.out.println("Enter ATM pin:");
int atmPin=sc.nextInt();
if((atmnumber == atmNumber)&&(atmpin == atmPin)) {
	System.out.println("Validation Done");
	while(true){
	System.out.println("1.View Available Balance\n2.Withdraw Balance \n3.Deposit Amount \n4.View MiniStatement \n5.Exit");
System.out.println("Enter Choice");
int ch=sc.nextInt();
if(ch == 1)
{
	op.viewBalance();
}
if(ch == 2) 
{
	System.out.println("Enter Amount to Withdraw:");
	double withdrawAmount=sc.nextDouble();
	op.withdrawAmount(withdrawAmount);
}
if(ch == 3)
{
	System.out.println("Enter Amount to Deposit:");
	double depositAmount=sc.nextDouble();
	op.depositAmount(depositAmount);
}
if(ch == 4) 
{
	op.viewMiniStatement();
}
if(ch == 5)
{
	System.out.println("Collect Your ATM Card\n    Thank you!!! ");
System.out.println(0);
}else 
{
	System.out.println("Please Enter correct Choice ");
}
}	
}else {
	System.out.println("!!!Incorrect ATM number or Pin!!!");
	System.exit(0);
}
	}
}

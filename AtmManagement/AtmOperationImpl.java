package com.AtmManagement;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperation{
	ATM atm=new ATM();
	Map<Double, String> miniStmt =new HashMap<>();
	@Override
	public void viewBalance() {
		// TODO Auto-generated method stub
		System.out.println("Available Balance is:"+ atm.getBalance());
	}

	@Override
	public void withdrawAmount(double withdrawAmount) {
		// TODO Auto-generated method stub
		if(withdrawAmount <=atm.getBalance()) {
			miniStmt.put(withdrawAmount,"Amount Withdrawn");
		System.out.println("Collect the Amount"+withdrawAmount);
		atm.setBalance(atm.getBalance()-withdrawAmount);
		viewBalance();}
		else {
			System.out.println("Insufficient Funds!!!");
		}
	}

	@Override
	public void depositAmount(double depositAmount) {
		// TODO Auto-generated method stub\
		miniStmt.put(depositAmount,"Amount Deposited");
		System.out.println(depositAmount+"Deposited Successfully");
	atm.setBalance(atm.getBalance()+depositAmount);
	viewBalance();
	}

	@Override
	public void viewMiniStatement() {
		// TODO Auto-generated method stub
		for(Map.Entry<Double, String> m:miniStmt.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}
	}

}

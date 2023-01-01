package com.AtmManagement;

public interface AtmOperation {
   public void viewBalance();
   public void withdrawAmount (double withdrawAmount);
   public void depositAmount(double depositAmount);
   public void viewMiniStatement(); 
}

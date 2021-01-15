package com.capgemini.modle;

import com.capgemini.exceptions.AccountNotFoundException;
import com.capgemini.exceptions.InsufficientBalanceException;

public interface Bank {
	boolean CreateAccount(Integer AccNo,Integer Deposit);
	boolean validateAccount(Integer AccNo)throws AccountNotFoundException; //Inputs Account no
	boolean depositAmount(Integer AccNo,Integer Amt); //Input Account no & Amount
	boolean withdrawAmount(Integer AccNo,Integer Amt) throws InsufficientBalanceException; //Input Account no & Amount
	boolean fundTransfer(Integer SAccNo,Integer RAccNo,Integer Amt) throws InsufficientBalanceException; //Input Account no & Amount
	Integer checkBalance(Integer AccNo);
}

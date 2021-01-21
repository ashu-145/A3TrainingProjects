package com.capgemini.service;

import com.capgemini.exceptions.AccountNotFoundException;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;

public interface Bank {
	boolean createAccount(Integer AccNo,Integer Deposit) throws InsufficientOpeningBalanceException;
	boolean validateAccount(Integer AccNo)throws AccountNotFoundException; //Inputs Account no
	Integer depositAmount(Integer accNo,Integer amt); //Input Account no & Amount
	Integer withdrawAmount(Integer accNo,Integer amt) throws InsufficientBalanceException; //Input Account no & Amount
	Integer[] fundTransfer(Integer sourceAccNo,Integer recieverAccNo,Integer amt) throws InsufficientBalanceException; //Input Account no & Amount
	Integer checkBalance(Integer AccNo);
}

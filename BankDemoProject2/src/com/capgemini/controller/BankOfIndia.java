package com.capgemini.controller;
import java.util.ArrayList;
import java.util.List;
import com.capgemini.exceptions.*;
import com.capgemini.modle.Bank;

public class BankOfIndia implements Bank {
	private Integer AccountNum;
	private Integer Balance;
	List<BankOfIndia> lst = new ArrayList<>();

	@Override
	public boolean validateAccount(Integer AccNo) throws AccountNotFoundException
	{
		for(BankOfIndia b:lst)
		{
			if(AccNo.equals(b.getAccountNum()))
				return true;
		}
		throw new AccountNotFoundException();
		
	}

	@Override
	public boolean depositAmount(Integer AccNo, Integer Amt) {
		for(BankOfIndia b:lst)
		{
			if(AccNo.equals(b.getAccountNum()))
			{
				b.setBalance(b.getBalance()+Amt);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean withdrawAmount(Integer AccNo, Integer Amt) throws InsufficientBalanceException {
		for(BankOfIndia b:lst)
		{
			if(AccNo.equals(b.getAccountNum()))
			{
				if(b.getBalance()-Amt>=500)
				{
					b.setBalance(b.getBalance()-Amt);
					return true;
				}
			}
		}
		throw new InsufficientBalanceException();
	}

	@Override
	public boolean fundTransfer(Integer SAccNo,Integer RAccNo, Integer Amt) throws InsufficientBalanceException {
		boolean checker =false;
		for(BankOfIndia b:lst)
		{
			if(SAccNo.equals(b.getAccountNum()))
			{
				//System.out.println(" s acc if condition");
				for(BankOfIndia b1:lst)
				{
					if(RAccNo.equals(b1.getAccountNum()))
					{
						if(b.getBalance()-Amt>=500)
						{
							//System.out.println(" r acc if condition");
							b.setBalance(b.getBalance()-Amt);
							b1.setBalance(b1.getBalance()+Amt);
							checker = true;
						}
						else
							throw new InsufficientBalanceException();
					}
				}
				
			}
		}
		return checker;
	}

	@Override
	public boolean CreateAccount(Integer AccNo, Integer Deposit) {
		BankOfIndia b = new BankOfIndia();
		b.setAccountNum(AccNo);
		boolean checker = false;
		for(BankOfIndia b1:lst)
		{
			if(AccNo.equals(b1.getAccountNum()))
			{
				checker = true;
				return false;
			}
				
		}
		if(checker)
		{
			return false;
		}
		else 
		{
			if(Deposit>=500)
			{
				b.setBalance(Deposit);
				return lst.add(b);
			}
			else
				return false;
		}
	}
	
	@Override
	public Integer checkBalance(Integer AccNo) {
		Integer bal=0;
		for(BankOfIndia b:lst)
		{
			if(AccNo.equals(b.getAccountNum()))
				bal =b.getBalance();
		}
		return bal;
	}

	public Integer getAccountNum() {
		return AccountNum;
	}

	public void setAccountNum(Integer accountNum) {
		AccountNum = accountNum;
	}

	public Integer getBalance() {
		return Balance;
	}

	public void setBalance(Integer balance) {
		Balance = balance;
	}

	
	

}

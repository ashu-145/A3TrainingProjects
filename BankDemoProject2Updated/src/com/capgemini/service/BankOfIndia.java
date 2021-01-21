package com.capgemini.service;
import com.capgemini.modle.Account;
import java.util.ArrayList;
import java.util.List;
import com.capgemini.exceptions.*;

public class BankOfIndia implements Bank {
	private List<Account> lst = new ArrayList<>();

	@Override
	public boolean validateAccount(Integer AccNo) throws AccountNotFoundException
	{
		for(Account a:lst)
		{
			if(AccNo.equals(a.getAccountNum()))
				return true;
		}
		throw new AccountNotFoundException();
		
	}

	@Override
	public Integer depositAmount(Integer accNo, Integer amt) {
		for(Account a:lst)
		{
			if(accNo.equals(a.getAccountNum()))
			{
				a.setBalance(a.getBalance()+amt);
				return a.getBalance();
			}
		}
		
		return null;
	}

	@Override
	public Integer withdrawAmount(Integer accNo, Integer amt) throws InsufficientBalanceException {
		for(Account a:lst)
		{
			if(accNo.equals(a.getAccountNum()))
			{
				if(a.getBalance()-amt>=500)
				{
					a.setBalance(a.getBalance()-amt);
					return a.getBalance();
				}
			}
		}
		throw new InsufficientBalanceException();
	}

	@Override
	public Integer[] fundTransfer(Integer sourceAccNo,Integer recieverAccNo, Integer amt) throws InsufficientBalanceException {
		Integer[] balance =null;
		for(Account a:lst)
		{
			if(sourceAccNo.equals(a.getAccountNum()))
			{
				//System.out.println(" s acc if condition");
				for(Account a1:lst)
				{
					if(recieverAccNo.equals(a1.getAccountNum()))
					{
						if(a.getBalance()-amt>=500)
						{
							//System.out.println(" r acc if condition");
							a.setBalance(a.getBalance()-amt);
							a1.setBalance(a1.getBalance()+amt);
							balance =new Integer[] {a.getBalance(),a1.getBalance()};
						}
						else
							throw new InsufficientBalanceException();
					}
				}
				
			}
		}
		return balance;
	}

	@Override
	public boolean createAccount(Integer accNo, Integer Deposit) throws InsufficientOpeningBalanceException {
		Account a = new Account();
		a.setAccountNum(accNo);
		boolean checker = false;
		for(Account a1:lst)
		{
			if(accNo.equals(a1.getAccountNum()))
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
				a.setBalance(Deposit);
				return lst.add(a);
			}
			else
				throw new InsufficientOpeningBalanceException();
		}
	}
	
	@Override
	public Integer checkBalance(Integer AccNo) {
		Integer bal=0;
		for(Account a:lst)
		{
			if(AccNo.equals(a.getAccountNum()))
				bal =a.getBalance();
		}
		return bal;
	}

	

}

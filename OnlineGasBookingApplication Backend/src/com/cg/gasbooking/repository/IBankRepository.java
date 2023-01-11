package com.cg.gasbooking.repository;

import com.cg.gasbooking.entity.Bank;

public interface IBankRepository{
	public Bank insertBank(Bank bank);
	public Bank updateBank(Bank bank);
	public Bank deleteBank(Bank bank);
}
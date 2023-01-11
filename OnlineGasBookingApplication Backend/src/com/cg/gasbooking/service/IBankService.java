package com.cg.gasbooking.service;

import com.cg.gasbooking.entity.Bank;

public interface IBankService {
	public Bank insertBank(Bank bank);
	public Bank updateBank(Bank bank);
	public Bank deleteBank(Bank bank);
}
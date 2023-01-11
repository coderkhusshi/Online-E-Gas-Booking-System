package com.cg.gasbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.gasbooking.entity.Admin;
import com.cg.gasbooking.entity.GasBooking;

public interface IAdminService {
	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin deleteAdmin(int adminId);
	public List<GasBooking>getAllBookings(int customerId);
	public List<GasBooking>getAllBookingsForDays(int customerId, LocalDate fromDate, LocalDate toDate);
}
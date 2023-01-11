package com.cg.gasbooking.repository;

import java.time.LocalDate;
import java.util.List;

import com.cg.gasbooking.entity.Admin;
import com.cg.gasbooking.entity.GasBooking;
import com.cg.gasbooking.exception.AdminNotFoundException;

public interface IAdminRepository {
	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException;
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException;
	public List<GasBooking>getAllBookings(int customerId);
	public List<GasBooking>getAllBookingsForDays(int customerId, LocalDate fromDate, LocalDate toDate);
}
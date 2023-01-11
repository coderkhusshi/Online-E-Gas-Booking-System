package com.cg.gasbooking.service;

import com.cg.gasbooking.entity.GasBooking;

public interface IGasBookingService {
	public GasBooking insertGasBooking(GasBooking gasBooking);
	public GasBooking updateGasBooking(GasBooking gasBooking);
	public GasBooking deleteGasBooking(GasBooking gasBooking);
	public GasBooking calculateBill(int customerId);
}
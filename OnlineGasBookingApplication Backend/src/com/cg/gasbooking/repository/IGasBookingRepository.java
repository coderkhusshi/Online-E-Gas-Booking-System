package com.cg.gasbooking.repository;

import com.cg.gasbooking.entity.GasBooking;
import com.cg.gasbooking.exception.GasBookingNotFoundException;

public interface IGasBookingRepository {
	public GasBooking insertGasBooking(GasBooking gasBooking);
	public GasBooking updateGasBooking(GasBooking gasBooking) throws GasBookingNotFoundException;
	public GasBooking deleteGasBooking(GasBooking gasBooking) throws GasBookingNotFoundException;
	public GasBooking calculateBill(int customerId)throws GasBookingNotFoundException;
}
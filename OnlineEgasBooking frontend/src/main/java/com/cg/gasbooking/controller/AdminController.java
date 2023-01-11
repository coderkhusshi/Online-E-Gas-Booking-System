package com.cg.gasbooking.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.gasbooking.entity.Admin;
import com.cg.gasbooking.entity.GasBooking;
import com.cg.gasbooking.exception.AdminNotFoundException;
import com.cg.gasbooking.exception.DuplicateIdException;
import com.cg.gasbooking.service.AdminService;

/**
 * @author Anshika Jain
 * @implSpec All implementation related to Admin which admin can access
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/Admin")
public class AdminController {
	@Autowired
	AdminService AdminService;

	/**
	 * @implSpec Reads all Admin data
	 * @return List<Admin>
	 */
	// URl http://localhost:8081/gasBooking/Admin/show
	@GetMapping(value = "/show", produces = "application/json")
	List<Admin> showAdmin() {
		List<Admin> AdminList = AdminService.showAdmin();
		return AdminList;
	}

	/**
	 * @implSpec Inserts the data into Admin table
	 * @return Admin
	 * @param Admin Object named admin
	 */
	// URl http://localhost:8081/gasBooking/Admin
	@PostMapping(consumes = "application/json", produces = "application/json")
	ResponseEntity<Admin> insertAdmin(@Valid @RequestBody Admin admin) throws DuplicateIdException {
		Admin ad = AdminService.insertAdmin(admin);
		if (ad.getAdminId() == 0) {
			throw new DuplicateIdException("Admin with this ID already Exsists");
		}
		return ResponseEntity.ok(admin);
	}

	/**
	 * @implSpec Updates the existing data
	 * @return Admin
	 * @param Admin Object named admin
	 */
	// URl http://localhost:8081/gasBooking/Admin
	@PutMapping(consumes = "application/json", produces = "application/json")
	ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin) throws AdminNotFoundException {
		Admin ad = AdminService.updateAdmin(admin);
		if (ad.getAdminId() == 0) {
			throw new AdminNotFoundException("Admin with this ID does not exists");
		}
		return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);
	}

	/**
	 * @implSpec Deletes the existing data using AdminId
	 * @return Admin
	 * @param AdminId
	 */

	// URl http://localhost:8081/gasBooking/Admin/143
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping(path = "/{AdminId}", produces = "application/json")
	ResponseEntity<Admin> deleteAdmin(@PathVariable("AdminId") int AdminId) throws AdminNotFoundException {
		Admin ad = AdminService.deleteAdmin(AdminId);
		if (ad.getAdminId() == 0) {
			throw new AdminNotFoundException("Admin with this ID does not exists");
		}
		return new ResponseEntity("Admin with Id " + AdminId + " is deleted", HttpStatus.OK);
	}

	/**
	 * @implSpec Reads the GasBooking data according to CustomerId
	 * @return GasBooking
	 * @param Customer Id named customerId
	 */

	// URl http://localhost:8081/gasBooking/Admin/
	@GetMapping(value = "/bookings/{customerId}", produces = "application/json")
	List<GasBooking> getAllBookings(@PathVariable("customerId") int customerId) {
		List<GasBooking> BookingList = AdminService.getAllBookings(customerId);
		return BookingList;
	}

	/**
	 * Reads the GasBooking data according to CustomerId and between specified date
	 * 
	 * @return GasBooking
	 * @param Customer Id customerId, Starting Date named fromDate, Ending Date
	 *                 named toDate
	 */

	// URl http://localhost:8081/gasBooking/Admin/150/2022-06-22/2022-08-22
	@GetMapping(value = "/{customerId}/{fromDate}/{toDate}", produces = "application/json")
	List<GasBooking> getAllBookingsForDays(@PathVariable("customerId") int customerId,
			@PathVariable("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@PathVariable("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
		List<GasBooking> BookingList = AdminService.getAllBookings(customerId);
		return BookingList;
	}

	/*// URl http://localhost:8081/gasBooking/Admin/ID
	@GetMapping(value = "/ID", produces = "application/json")
	int findadminId() {
		int Id = AdminService.findadminId();
		return Id;
	}*/

	// http://localhost:8081/gasBooking/Admin/login
	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	ResponseEntity<Admin> validateAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
		Admin ad = AdminService.validateAdmin(admin);
		if (ad == null) {
			throw new AdminNotFoundException("admin with username and password not available!");
		}
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}

	// URl http://localhost:8081/gasBooking/Admin/pass
	@PutMapping(path = "/pass", consumes = "application/json", produces = "application/json")
	ResponseEntity<Admin> updatePass(@Valid @RequestBody Admin admin) throws AdminNotFoundException {
		Admin ad = AdminService.updatePass(admin);

		return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);
	} 


	//http://localhost:8080/gasBooking/Admin
	@GetMapping(path = "{adminId}",produces = "application/json")
	ResponseEntity<Admin> viewAdmin(@PathVariable("adminId") int adminId) 
	{
		Admin ad = AdminService.viewAdmin(adminId);
		return ResponseEntity.ok(ad);
	}
	
	
		
}

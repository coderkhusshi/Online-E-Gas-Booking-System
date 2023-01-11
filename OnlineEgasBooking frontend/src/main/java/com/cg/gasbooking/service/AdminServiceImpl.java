package com.cg.gasbooking.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.gasbooking.entity.Admin;

import com.cg.gasbooking.entity.GasBooking;
import com.cg.gasbooking.exception.AdminNotFoundException;
import com.cg.gasbooking.exception.DuplicateIdException;
import com.cg.gasbooking.repository.AdminRepository;
import com.cg.gasbooking.repository.IGasBookingRepository;

@Service
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	AdminRepository AdminRepo;	
	
	@Autowired
	IGasBookingRepository GasRepo;
	
	@Transactional
	@Override
	public List<Admin> showAdmin() 
	{	
		return AdminRepo.findAll();
	}
	
	@Transactional
	@Override
	public Admin insertAdmin(Admin admin) throws DuplicateIdException 
	{
		Optional<Admin> adminObj=AdminRepo.findById(admin.getAdminId());
		if (adminObj.isPresent())
		{
			throw new DuplicateIdException("Admin with this ID exists");
		}
		
		List<Admin> adminObj2 = AdminRepo.findAll();
        if(!(adminObj2.isEmpty())) {
            throw new DuplicateIdException("Customer with this ID exists");
        }
		return AdminRepo.saveAndFlush(admin);	
	}

	@Transactional
	@Override
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException
	{
		Optional<Admin> adminObj=AdminRepo.findById(admin.getAdminId());
		if (!(adminObj.isPresent()))
		{
			throw new AdminNotFoundException("Admin with this ID does not exists");
		}
		
		Optional<Admin> updatedAdmin=AdminRepo.findById(admin.getAdminId());
		Admin updated=updatedAdmin.get();
			
		updated.setUsername(admin.getUsername());
		updated.setPassword(admin.getPassword());
		updated.setAddress(admin.getAddress());
		updated.setMobileNumber(admin.getMobileNumber());
		updated.setEmail(admin.getEmail());
		
		return updated;
	}

	@Transactional
	@Override
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException
	{
		Optional<Admin> adminObj=AdminRepo.findById(adminId);
		if (!(adminObj.isPresent()))
		{
			throw new AdminNotFoundException("Admin with this ID does not exists");
		}
		AdminRepo.deleteById(adminId);
		return adminObj.get();
	}

	@Transactional
	@Override
	public List<GasBooking> getAllBookings(int customerId) 
	{		
		List<GasBooking> gasBooking=GasRepo.getAllBookings(customerId);
		return gasBooking;
	}
		
	@Transactional
	@Override
	public List<GasBooking> getAllBookingsForDays(int customerId, LocalDate fromDate, LocalDate toDate) 
	{
		List<GasBooking> gasBooking=GasRepo.getAllBookingsForDays(customerId, fromDate,toDate) ;
		return gasBooking;
	}

	@Transactional
	@Override
	public int findadminId() {
		int Id =AdminRepo.findadminId();
		return Id;
	}

	@Transactional
	@Override
	public Admin validateAdmin(Admin admin) throws AdminNotFoundException {
		
		Admin ad = AdminRepo.validateAdmin(admin.getUsername(),admin.getPassword());
		if (ad == null) 
		{
			throw new AdminNotFoundException("admin with this username and password does not exists");
		}
		return AdminRepo.validateAdmin(admin.getUsername(),admin.getPassword());
	}

	@Transactional
	@Override
	public Admin updatePass(Admin admin) throws AdminNotFoundException {
		
		Admin adminObj=AdminRepo.updatePass(admin.getUsername(),admin.getEmail());
		System.out.println(adminObj);
		if ((adminObj==null))
		{
			throw new AdminNotFoundException("Admin does not exists");
		}
		
		adminObj.setPassword(admin.getPassword());
		
		return AdminRepo.updatePass(admin.getUsername(),admin.getEmail());
	}
	
	
	@Transactional
	@Override
	public Admin viewAdmin(int adminId) 
	{
		Optional<Admin> adminObj = AdminRepo.findById(adminId);
		Admin admin = adminObj.get();
		return admin;
	}
}
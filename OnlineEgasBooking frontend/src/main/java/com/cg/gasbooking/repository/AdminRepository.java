package com.cg.gasbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.gasbooking.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>
{
	@Query ("SELECT max(adminId) from Admin")
	public int findadminId();
	
	@Query("SELECT admin from Admin admin WHERE admin.username=:username and admin.password=:password")
	public Admin validateAdmin(@Param("username") String username,@Param("password") String password);
	
	
	@Query("SELECT admin from Admin admin WHERE admin.username=:username and admin.email=:email")
	public Admin updatePass(@Param("username") String username,@Param("email") String email);

}
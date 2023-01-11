package com.cg.gasbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.gasbooking.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
	@Query("SELECT customer from Customer customer WHERE customer.username=:username and customer.password=:password")
	public Customer validateCustomer(@Param("username") String username,@Param("password") String password);
	
	@Query("SELECT customer from Customer customer WHERE customer.username=:username and customer.email=:email")
	public Customer updatePass(@Param("username") String username,@Param("email") String email);
	
	
	@Query("SELECT customer from Customer customer WHERE customer.email=:email")
    public Customer emailVerify(@Param("email") String email);
	
	@Query("SELECT customer from Customer customer WHERE customer.mobileNumber=:mobileNumber")
    public Customer phoneVerify(@Param("mobileNumber") String mobileNumber);
	
	@Query("SELECT customer from Customer customer WHERE customer.pan=:pan")
    public Customer panVerify(@Param("pan") String pan);
	
	@Query("SELECT customer from Customer customer WHERE customer.accountNo=:accountNo ")
    public Customer accountverify(@Param("accountNo") String accountNo);

}
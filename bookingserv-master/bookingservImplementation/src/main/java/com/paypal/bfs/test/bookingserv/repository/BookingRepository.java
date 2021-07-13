package com.paypal.bfs.test.bookingserv.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.bookingserv.entity.BookingEntity;



@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
	/**
	 *  Validation of Duplicate data 
	 *  Duplicate data check will done based on 5 Parameter
	 *  1. First Name 
	 *  2. Second Name 
	 *  3. Date of Birth
	 *  4. Check-in Date
	 *  5. Check-out Date
	 */
	
	@Query("SELECT COUNT(*) FROM BookingEntity M WHERE M.firstName=:first_name AND M.lastName=:last_name AND M.datebirth=:date_birth AND M.checkIn =:check_in AND M.checkOUT=:check_out")
	public int dataexists(@Param("first_name") String first_name ,@Param("last_name") String last_name ,
			@Param("date_birth") Date date_birth , @Param("check_in") Date check_in , @Param("check_out") Date check_out);

}

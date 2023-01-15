package com.kunal.spring.datjpatutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kunal.spring.datjpatutorial.Entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	
	public List<Student> findByFirstName(String firstName);
	public List<Student> findBylastNameContaining(String last);
	public List<Student> findByGuardianName(String GuardianName);
	
	//JPQL to get result on custom methods
	@Query("Select s from  Student s where s.emailId= ?1")
    Student getStudentByEmailAddress(String emailId);
	
	
	//JPQL to get result on custom methods, to get only one attribute of student
    @Query("Select s.firstName from  Student s where s.emailId= ?1")
	String getStudentFirstNameByEmailAddress(@Param("emailId")String emailId);
    
    //We can also perform operation using native SQL query
    //Native Query
    //We can use named param also to pass value to query it is more readable
    @Query(
    		value= " Select * from tbl_student where email_address = :emailId",
    		nativeQuery=true
    		
    		)
    Student getStudentByEmailAddressNative(String emailId);
	
	
	
}

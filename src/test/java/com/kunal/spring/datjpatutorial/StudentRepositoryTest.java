package com.kunal.spring.datjpatutorial;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kunal.spring.datjpatutorial.Entity.Guardian;
import com.kunal.spring.datjpatutorial.Entity.Student;
import com.kunal.spring.datjpatutorial.repository.StudentRepository;




@SpringBootTest

//@DataJpaTest Ideally we use this as it test and dump the data, but for this example we want our data to store in DB

public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
/*	@Test
	public void saveStudent() {
		new Student();
		Student s = Student
				.builder().firstName("Kishor").lastName("Kunal").emailId("kishor.com").guardianEmail("hare.com").guardianMobile("9123276039").guardianName("Hare").build();
		
		studentRepository.save(s);
				               
	}*/
	
	/*@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder().name("hare").email("hare.com").mobile("9123276039").build();
		
		Student s = Student
				.builder().firstName("Kishor").lastName("Kunal").emailId("kishor1.com").guardian(guardian).build();
		
		studentRepository.save(s);
	}*/
	
	@Test
	public void printAllStudent() {
		List<Student> studentList	= studentRepository.findAll();
		
		System.out.println("Student List = "+ studentList);
	}
	
	@Test
	public void printStudentByFirstName() {
		List<Student> students = studentRepository.findByFirstName("Kishor");
		System.out.println("Students with first name as Kishor are: "+students);
	}
	@Test
	public void printStudentByLastNameContaining() {
		List<Student> students = studentRepository.findBylastNameContaining("nal");
		System.out.println("Students with last name containing nal are: "+students);
	}
	@Test
	public void printStudentByGuardianName() {
		List<Student> students = studentRepository.findByGuardianName("Hare");
		System.out.println("Studnents with Guardian name as Hare are: "+students);
	}
	@Test
	public void getStudentByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("kishor1.com");
		System.out.println("Students with email id as kishor1.com is: "+student);
	}
	@Test
	public void getStudentFirstNameByEmailAddress() {
		String firstName = studentRepository.getStudentFirstNameByEmailAddress("kishor1.com");
		System.out.println("Student's first name with email id as kishor1.com is: "+firstName);
	}
	@Test
	public void getStudentByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailAddressNative("kishor1.com");
		System.out.println("Native: Students with email id as kishor1.com is: "+student);
	}
}


package com.myproject.cruddemo;

import com.myproject.cruddemo.dao.StudentDAO;
import com.myproject.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			// createStudent(studentDAO);
			//readStudent(studentDAO);
			// updateStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println(numRowsDeleted + " rows deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 5;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId = 1;

		Student myStudent = studentDAO.findById(studentId);

		myStudent.setFirstName("Scop");

		myStudent.setLastName("Doo");

		myStudent.setEmail("Scooby@gmail.com");

		studentDAO.update(myStudent);

		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findByLastName("Bunny");
		for(Student theStudent : theStudents){
			System.out.println(theStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Student tempStudent = new Student("Ömer Fatih","Aslan","example@gmail.com");

		// studentDAO.save(tempStudent);

		int theId = 3;

		Student myStudent = studentDAO.findById(theId);

		System.out.println(myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new object...");
		Student tempStudent = new Student("Bugs","Bunny","bugsbunny@gmail.com");

		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated ID:" + tempStudent.getId() + tempStudent.toString());
	}

}

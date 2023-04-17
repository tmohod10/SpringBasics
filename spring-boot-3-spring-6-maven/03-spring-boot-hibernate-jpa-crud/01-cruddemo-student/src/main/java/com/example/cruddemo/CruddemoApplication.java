package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
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

	// This is executed after the spring beans are loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudents(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			removeStudent(studentDAO);
//			removeAllStudents(studentDAO);
		};
	}

	private void removeAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students ...");
		int numOfRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of rows deleted : " + numOfRowsDeleted);
	}

	private void removeStudent(StudentDAO studentDAO) {
		int studentId = 6;
		System.out.println("Deleting student id : " + studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id : primary key
		int studentId = 1;
		System.out.println("Getting student with student id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change the first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Paul");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student : " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Public");

		// display the list of students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void readStudents(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating a new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@abc.com");

		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id : " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id : " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student : " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating new student object ...");
		Student tempStudent1 = new Student("John", "Doe", "john@abc.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@abc.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@abc.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@abc.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}
}

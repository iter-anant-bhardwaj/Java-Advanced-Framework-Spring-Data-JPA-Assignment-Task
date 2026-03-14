package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.Project;
import com.capgemini.entity.Student;
import com.capgemini.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public void saveStudent(Student student) {
		studentRepository.save(student);
		System.out.println("Student Saved Successfully!");
	}

	public void saveStudents(List<Student> students) {
		studentRepository.saveAll(students);
		System.out.println("Students Saved Successfully!");
	}

	public void getStudent(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = optional.get();
		System.out.println(student);
		System.out.println("Student Read Successfully!");
	}

	public void getStudents() {
		List<Student> students = studentRepository.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("Students Read Successfully!");
	}

	public void updateStudent(Integer id, String mailId, Long contactNumber, String name, String description) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = optional.get();
		student.setMailId(mailId);
		student.setContactNumber(contactNumber);
		Project project = student.getProject();
		project.setName(name);
		project.setDescription(description);
		student.setProject(project);
		studentRepository.save(student);
		System.out.println("Student Updated Successfully!");
	}

	public void deleteStudent(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = optional.get();
		student.setProject(null);
		studentRepository.delete(student);
		System.out.println("Student Deleted Successfully!");
	}

	public void deleteStudents() {
		List<Student> students = studentRepository.findAll();

		for (Student student : students) {
			student.setProject(null);
		}

		studentRepository.deleteAll(students);
		System.out.println("Students Deleted Successfully!");
	}
	
}

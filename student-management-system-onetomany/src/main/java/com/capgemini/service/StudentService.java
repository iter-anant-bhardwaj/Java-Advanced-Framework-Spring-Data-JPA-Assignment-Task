package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.Project;
import com.capgemini.entity.Student;
import com.capgemini.repository.StudentRepository;

import jakarta.transaction.Transactional;

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

	@Transactional
	public void getStudent(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = optional.get();
		
		List<Project> projects = student.getProjects();
		System.out.println(student);
		for(Project p : projects) {
			System.out.println(p);
		}
		
		System.out.println("Student Read Successfully!");
	}
	@Transactional
	public void getStudents() {
		List<Student> students = studentRepository.findAll();
		for (Student student : students) {
			List<Project> projects = student.getProjects();
			System.out.println(student);
			for(Project p : projects) {
				System.out.println(p);
			}
		}
		System.out.println("Students Read Successfully!");
	}
	@Transactional
	public void updateStudent(Integer id, String mailId, Long contactNumber, Integer projectId, String name, String description) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = optional.get();
		
		student.setMailId(mailId);
		student.setContactNumber(contactNumber);
		List<Project> projects = student.getProjects();
		for(Project p : projects) {
	        if(p.getId().equals(projectId)) {
	            p.setName(name);
	            p.setDescription(description);
	        }
	    }
//		student.setProjects(projects);
		studentRepository.save(student);
		System.out.println("Student Updated Successfully!");
	}

	public void deleteStudent(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = optional.get();
//		student.setProjects(null);
		studentRepository.delete(student);
		System.out.println("Student Deleted Successfully!");
	}

	public void deleteStudents() {
		List<Student> students = studentRepository.findAll();

//		for (Student student : students) {
//			student.setProjects(null);
//		}

		studentRepository.deleteAll(students);
		System.out.println("Students Deleted Successfully!");
	}
	
}

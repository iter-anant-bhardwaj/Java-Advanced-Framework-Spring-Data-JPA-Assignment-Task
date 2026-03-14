package com.capgemini.execution;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.capgemini.entity.Project;
import com.capgemini.entity.Student;
import com.capgemini.service.StudentService;

@Component
public class TaskManager implements CommandLineRunner {
	@Autowired
	StudentService studentService;

	@Override
	public void run(String... args) throws Exception {
		
//		Project project1 = new Project();
//		project1.setName("ChatBot");
//		project1.setDescription("AI based");
//		
//		Project project2 = new Project();
//		project2.setName("E commerce");
//		project2.setDescription("Mern based");
//		
//		Project project3 = new Project();
//		project3.setName("Train RA");
//		project3.setDescription("C# based");
//		
//		List<Project> projects = new ArrayList<Project>();
//		projects.add(project1);
//		projects.add(project2);
//		projects.add(project3);
//		
//		Student student1 = new Student();
//		student1.setName("Raja");
//		student1.setMailId("raja@gmail.com");
//		student1.setContactNumber(9876543210L);
//		student1.setProjects(projects);
//		studentService.saveStudent(student1);
//		
//		Student student2 = new Student();
//		student2.setName("Rani");
//		student2.setMailId("rani@gmail.com");
//		student2.setContactNumber(9876543211L);
//		student2.setProjects(projects);
//		studentService.saveStudent(student2);
//		
//		Student student3 = new Student();
//		student3.setName("Rocky");
//		student3.setMailId("rocky@gmail.com");
//		student3.setContactNumber(9876543212L);
////		studentService.saveStudent(student3);
//		
//		Student student4 = new Student();
//		student4.setName("Reena");
//		student4.setMailId("reena@gmail.com");
//		student4.setContactNumber(9876543213L);
////		studentService.saveStudent(student4);
//		
//		List<Student> students = new ArrayList<Student>();
//		students.add(student2);
//		students.add(student3);
//		students.add(student4);
		
//		studentService.saveStudents(students);
		
//		studentService.getStudent(1);
		
//		studentService.updateStudent(2, "king@gmail.com", 8855885588L, 5, "Message app", "AI based");
		
		studentService.deleteStudent(2);
		
		
	}
}

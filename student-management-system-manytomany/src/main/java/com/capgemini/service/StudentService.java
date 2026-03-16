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
    private StudentRepository studentRepository;

    // Save single student
    public void saveStudent(Student student) {
        studentRepository.save(student);
        System.out.println("Student saved successfully!");
    }

    // Save multiple students
    public void saveStudents(List<Student> students) {
        studentRepository.saveAll(students);
        System.out.println("Students saved successfully!");
    }

    // Get student by id
    public Student getStudent(Integer id) {

        Optional<Student> optional = studentRepository.findById(id);

        if(optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    // Get all students
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    // Update student
    public void updateStudent(Integer id, String mailId, Long contactNumber) {

        Optional<Student> optional = studentRepository.findById(id);

        if(optional.isPresent()) {

            Student student = optional.get();
            student.setMailId(mailId);
            student.setContactNumber(contactNumber);

            studentRepository.save(student);

            System.out.println("Student updated successfully!");
        }
        else {
            System.out.println("Student not found!");
        }
    }

    // Delete student
    public void deleteStudent(Integer id) {

        if(studentRepository.existsById(id)) {

            studentRepository.deleteById(id);

            System.out.println("Student deleted successfully!");
        }
        else {
            System.out.println("Student not found!");
        }
    }

    // Delete all students
    public void deleteStudents() {
        studentRepository.deleteAll();
        System.out.println("All students deleted successfully!");
    }

}

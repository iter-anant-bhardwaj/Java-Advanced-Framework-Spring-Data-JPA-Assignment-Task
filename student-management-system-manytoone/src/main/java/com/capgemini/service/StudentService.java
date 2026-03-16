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


    public void saveStudent(Student student) {
        studentRepository.save(student);
        System.out.println("Student Saved Successfully!");
    }


    public void saveStudents(List<Student> students) {
        studentRepository.saveAll(students);
        System.out.println("Students Saved Successfully!");
    }


    public Student getStudent(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            Student student = optional.get();
            System.out.println("Student Found: " + student);
            return student;
        } else {
            System.out.println("Student Not Found!");
            return null;
        }
    }


    public List<Student> getStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("Students Read Successfully!");
        return students;
    }


    public void updateStudent(Integer id, String mailId, Long contactNumber) {

        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            Student student = optional.get();
            student.setMailId(mailId);
            student.setContactNumber(contactNumber);

            studentRepository.save(student);
            System.out.println("Student Updated Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }


    public void updateStudentDetails(Student student) {
        studentRepository.save(student);
        System.out.println("Student Details Updated Successfully!");
    }

    // DELETE BY ID
    public void deleteStudent(Integer id) {

        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            System.out.println("Student Deleted Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    public void deleteStudents() {
        studentRepository.deleteAll();
        System.out.println("All Students Deleted Successfully!");
    }


    public long countStudents() {
        long count = studentRepository.count();
        System.out.println("Total Students: " + count);
        return count;
    }


    public boolean studentExists(Integer id) {
        return studentRepository.existsById(id);
    }

}

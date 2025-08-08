package com.example.Student_mg1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<StudentEntity> getAllStudents() {
        return repository.findAll();
    }

    public Optional<StudentEntity> getStudentByRollNo(int rollNo) {
        return repository.findById(rollNo);
    }

    public StudentEntity addStudent(StudentEntity student) {
        return repository.save(student);
    }

    public StudentEntity updateStudent(int rollNo, StudentEntity updatedStudent) {
        return repository.findById(rollNo)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setAddress(updatedStudent.getAddress());
                    student.setEmail(updatedStudent.getEmail());
                    student.setMobileNumber(updatedStudent.getMobileNumber());
                    student.setStandard(updatedStudent.getStandard());
                    student.setMarks(updatedStudent.getMarks());
                    return repository.save(student);
                })
                .orElse(null);
    }

    public boolean deleteStudent(int rollNo) {
        if (repository.existsById(rollNo)) {
            repository.deleteById(rollNo);
            return true;
        }
        return false;
    }
}

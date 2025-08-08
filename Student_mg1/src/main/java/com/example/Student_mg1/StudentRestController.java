package com.example.Student_mg1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:5500"})
public class StudentRestController {

    @Autowired
    private StudentService service;

    
 // Add new student
    @PostMapping
    public StudentEntity addStudent(@RequestBody StudentEntity student) {
        return service.addStudent(student);
    }

    
    
    
    // Get student by rollNo
    @GetMapping("/{rollNo}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable int rollNo) {
        Optional<StudentEntity> student = service.getStudentByRollNo(rollNo);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    
    
    // Update student by rollNo
    @PutMapping("/{rollNo}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable int rollNo, @RequestBody StudentEntity updatedStudent) {
        StudentEntity student = service.updateStudent(rollNo, updatedStudent);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    
    
    
    
    
    // Delete student by rollNo
    @DeleteMapping("/{rollNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int rollNo) {
        if (service.deleteStudent(rollNo)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
    
    
    
    
    // Get all students
    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return service.getAllStudents();
    }

   
}

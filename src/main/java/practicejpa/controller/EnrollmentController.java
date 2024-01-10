package practicejpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import practicejpa.domain.enrollment.Enrollment;
import practicejpa.service.EnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollment")
public class EnrollmentController {
    @Autowired
     private EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<Enrollment>> getEnrollment(){
        List<Enrollment> enrollments = enrollmentService.getAllEnrollment();
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Enrollment> saveEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment savedEnrollment = enrollmentService.saveEnrollment(enrollment);
        return new ResponseEntity<>(savedEnrollment, HttpStatus.CREATED);
    }

}

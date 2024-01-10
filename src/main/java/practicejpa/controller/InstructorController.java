package practicejpa.controller;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practicejpa.domain.instructor.Instructor;
import practicejpa.payload.instructor.InstructorRequest;
import practicejpa.service.InstructorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")

public class InstructorController
{
    private InstructorService instructorService;

    @GetMapping
    public Object getAll(){
        return instructorService.getAll();

    }

    @PostMapping
    public Instructor createInstructor(@RequestBody @Valid InstructorRequest payload){
        return instructorService.createInstructor(payload);
    }
 }

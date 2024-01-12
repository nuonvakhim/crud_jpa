package practicejpa.controller;


import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practicejpa.domain.instructor.Instructor;
import practicejpa.payload.instructor.InstructorRequest;
import practicejpa.payload.instructor.InstructorResponse;
import practicejpa.service.InstructorService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class InstructorController
{
    private final InstructorService instructorService;

    @GetMapping("/instructor")
    public Object getAll(){
        return instructorService.getAll();

    }
    @GetMapping("/instructor/{id}")
    public Object getByID(@PathVariable Long id){
        return instructorService.getById(id);
    }
    @PostMapping("/instructor")
    public Instructor createInstructor(@RequestBody @Valid InstructorRequest payload){
        return instructorService.createInstructor(payload);
    }

    @PutMapping("/instructor/{id}")
    public Instructor updateInstructor(@PathVariable Long id, @RequestBody @Valid InstructorRequest payload){
        return instructorService.updateInstructor(id, payload);
    }
    @DeleteMapping("/instructor/{id}")
    public void deleteInstructor(@PathVariable Long id) throws  Exception{
        instructorService.deleteInstructor(id);
    }
 }

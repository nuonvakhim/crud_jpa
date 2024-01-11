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
@RequestMapping("/api/v1/instructor")
@RequiredArgsConstructor
public class InstructorController
{
    private final InstructorService instructorService;

    @GetMapping
    public Object getAll(){
        return instructorService.getAll();

    }
    @GetMapping("/{id}")
    public Object getByID(@PathVariable Long id){
        return instructorService.getById(id);
    }
    @PostMapping
    public Instructor createInstructor(@RequestBody @Valid InstructorRequest payload){
        return instructorService.createInstructor(payload);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable Long id, @RequestBody @Valid InstructorRequest payload){
        return instructorService.updateInstructor(id, payload);
    }
    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) throws  Exception{
        instructorService.deleteInstructor(id);
    }
 }

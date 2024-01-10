                     package practicejpa.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practicejpa.domain.student.Student;
import practicejpa.payload.student.StudentRequest;
import practicejpa.service.StudentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;


    @PostMapping
    public Student createStudent(@RequestBody @Valid StudentRequest payload){
        return studentService.createStudent(payload);
    }
    @GetMapping
    public Object fetchStudent(){
        return studentService.getStudents();
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") Long student_id, @RequestBody @Valid StudentRequest payload) {
        return studentService.updateStudent(payload, student_id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) throws Exception{
        studentService.deleteStudent(id);

    }

}

package practicejpa.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practicejpa.domain.student.Student;
import practicejpa.payload.student.StudentRequest;
import practicejpa.service.StudentService;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/student")
    public Student createStudent(@RequestBody @Valid StudentRequest payload){
        return studentService.createStudent(payload);
    }
    @GetMapping("/student")
    public Object fetchStudent(){
        return studentService.getStudents();
    }

    @GetMapping("/student/{id}")
    public Object getById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable("id") Long student_id, @RequestBody @Valid StudentRequest payload) {
        return studentService.updateStudent(payload, student_id);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) throws Exception{
        studentService.deleteStudent(id);

    }
}

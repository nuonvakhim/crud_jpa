package practicejpa.service;

import practicejpa.domain.student.Student;
import practicejpa.payload.student.StudentRequest;
import practicejpa.payload.student.StudentResponse;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentRequest payload);


    List<StudentResponse> getStudents();

    Student updateStudent(StudentRequest payload, Long studentId);

    void deleteStudent(Long id);

    StudentResponse getById(Long id);
}

package practicejpa.service;

import practicejpa.domain.instructor.Instructor;
import practicejpa.payload.instructor.InstructorRequest;
import practicejpa.payload.instructor.InstructorResponse;

import java.util.List;

public interface InstructorService {
    List<InstructorResponse> getAll();

    Instructor createInstructor(InstructorRequest payload);

    Instructor updateInstructor(Long id, InstructorRequest payload);

    void deleteInstructor(Long id);


    InstructorResponse getById(Long id);
}

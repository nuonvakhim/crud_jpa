package practicejpa.service;

import practicejpa.domain.instructor.Instructor;
import practicejpa.payload.instructor.InstructorRequest;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAll();

    Instructor createInstructor(InstructorRequest payload);
}

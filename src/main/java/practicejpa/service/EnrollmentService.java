package practicejpa.service;

import practicejpa.domain.enrollment.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> getAllEnrollment();

    Enrollment saveEnrollment(Enrollment enrollment);
}

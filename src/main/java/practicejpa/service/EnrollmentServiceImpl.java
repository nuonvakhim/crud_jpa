package practicejpa.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practicejpa.domain.enrollment.Enrollment;
import practicejpa.domain.enrollment.EnrollmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService{
    private final EnrollmentRepository enrollmentRepository;
    @Override
    public List<Enrollment> getAllEnrollment() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }
}

package practicejpa.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import practicejpa.domain.department.Department;
import practicejpa.domain.instructor.Instructor;
import practicejpa.domain.instructor.InstructorRepository;
import practicejpa.payload.instructor.InstructorRequest;
import practicejpa.payload.instructor.InstructorResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService{
    private final InstructorRepository repository;
    @Override
    public List<InstructorResponse> getAll() {
       List<Instructor> instructors = repository.findAll();
       return instructors.stream()
               .map(Instructor::toInstructorResponse)
               .collect(Collectors.toList());
    }

    @Override
    public Instructor createInstructor(InstructorRequest payload) {

        var depart = Department.builder()
                .departmentName(payload.getDepartmentName())
                .departmentAddress(payload.getDepartmentAddress())
                .departmentCode(payload.getDepartmentCode())
                .build();
        var ins = Instructor.builder()
                .instructorName(payload.getInstructorName())
                .department(depart)
                .build();
        return repository.save(ins);
    }


}

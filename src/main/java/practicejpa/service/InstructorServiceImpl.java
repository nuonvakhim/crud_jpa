package practicejpa.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import practicejpa.domain.department.Department;
import practicejpa.domain.department.DepartmentRepository;
import practicejpa.domain.instructor.Instructor;
import practicejpa.domain.instructor.InstructorRepository;
import practicejpa.payload.instructor.InstructorRequest;
import practicejpa.payload.instructor.InstructorResponse;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService{

    private final InstructorRepository repository;

    private final DepartmentRepository departmentRepository;
    @Override
    public List<InstructorResponse> getAll() {
       List<Instructor> instructors = repository.findAll();
       return instructors.stream()
               .map(Instructor::toInstructorResponse)
               .collect(Collectors.toList());
    }

    @Override
    public Instructor createInstructor(InstructorRequest payload) {

//        var depart = Department.builder()
//                .departmentName(payload.getDepartmentName())
//                .departmentAddress(payload.getDepartmentAddress())
//                .departmentCode(payload.getDepartmentCode())
//                .build();
        var ins = Instructor.builder()
                .instructorName(payload.getInstructorName())
                .department(departmentRepository.findById(payload.getDepartmentId()).get())
                .build();
        return repository.save(ins);
    }

    @Transactional
    @Override
    public Instructor updateInstructor(Long id, InstructorRequest payload) {
        var update= repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not Found this ID"));
        update.setInstructorName(payload.getInstructorName());
        update.setDepartment(Department.builder()
                    .departmentId(payload.getDepartmentId())
//                .departmentName(payload.getDepartmentName())
//                .departmentAddress(payload.getDepartmentAddress())
//                .departmentCode(payload.getDepartmentCode())
                .build());
        return repository.save(update);
    }

    @Override
    public void deleteInstructor(Long id) {
        var delete= repository.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
            repository.deleteById(delete.getInstructorId());

    }

    @Override
    public InstructorResponse getById(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("ID not found")).toInstructorResponse();
    }


}

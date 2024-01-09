package practicejpa.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practicejpa.payload.Department;
import practicejpa.payload.RequestDepartment;
import practicejpa.repository.DepartmentRepository;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(RequestDepartment payload) {
        var d = Department.builder()
                .departmentAddress(payload.getDepartmentAddress())
                .departmentName(payload.getDepartmentName())
                .departmentCode(payload.getDepartmentCode())
                .build();
        return departmentRepository.save(d);
    }

    @Override
    public void deleteDepartment(Long id) {

        var findId = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found!"));
        departmentRepository.deleteById(findId.getDepartmentId());
    }

    @Override
    public Department updateDepartment(RequestDepartment payload, Long departmentId) {

        var id = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("id not found"));

        id.setDepartmentAddress(payload.getDepartmentAddress());
        id.setDepartmentName(payload.getDepartmentName());
        id.setDepartmentCode(payload.getDepartmentCode());
        return  departmentRepository.save(id);
    }
}

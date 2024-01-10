package practicejpa.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practicejpa.domain.department.Department;
import practicejpa.payload.department.RequestDepartment;
import practicejpa.domain.department.DepartmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(RequestDepartment payload) {
        var d = Department.builder()
                .departmentAddress(payload.getDepartmentAddress())
                .departmentName(payload.getDepartmentName())
                .departmentCode(payload.getDepartmentCode())
                .build();
        return departmentRepository.save(d);
    }


    @Override
    public Department updateDepartment(RequestDepartment payload, Long departmentId) {

        var id = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("id not found"));

        id.setDepartmentAddress(payload.getDepartmentAddress());
        id.setDepartmentName(payload.getDepartmentName());
        id.setDepartmentCode(payload.getDepartmentCode());
        return  departmentRepository.save(id);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(()-> new RuntimeException("This ID isd not found!!!"));
    }

    @Override
    public void deleteDepartment(Long id) {

        var findId = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found!"));
        departmentRepository.deleteById(findId.getDepartmentId());
    }

}

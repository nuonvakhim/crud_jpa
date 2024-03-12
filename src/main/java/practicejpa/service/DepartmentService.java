package practicejpa.service;

import practicejpa.domain.department.Department;
import practicejpa.payload.department.RequestDepartment;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(RequestDepartment payload);

    void deleteDepartment(Long id);

    Department updateDepartment(RequestDepartment payload, Long departmentId);

    List<Department> fetchDepartmentList();

    Department fetchById(Long departmentId);
}

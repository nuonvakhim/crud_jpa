package practicejpa.service;

import practicejpa.payload.Department;
import practicejpa.payload.RequestDepartment;

public interface DepartmentService {

    Department saveDepartment(RequestDepartment payload);

    void deleteDepartment(Long id);

    Department updateDepartment(RequestDepartment payload, Long deppartmentId);
}

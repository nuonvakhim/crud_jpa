package practicejpa.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import practicejpa.domain.department.Department;
import practicejpa.payload.department.RequestDepartment;
import practicejpa.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @GetMapping
    public List<Department> fetchDepartmentList(){

        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/{id}")
    public Department fetchById(@PathVariable("id") Long departmentId ){
        return departmentService.fetchById(departmentId);
    }
    @PostMapping
    public Department createDepartment(@RequestBody RequestDepartment payload){
        return departmentService.createDepartment(payload);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable Long id) throws Exception{
         departmentService.deleteDepartment(id);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody @Valid RequestDepartment payload){
        return departmentService.updateDepartment(payload, id);
    }
}



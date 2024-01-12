package practicejpa.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import practicejpa.domain.department.Department;
import practicejpa.payload.department.RequestDepartment;
import practicejpa.service.DepartmentService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/department")
    public List<Department> fetchDepartmentList(){

        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/department/{id}")
    public Department fetchById(@PathVariable("id") Long departmentId ){
        return departmentService.fetchById(departmentId);
    }
    @PostMapping("/department")
    public Department createDepartment(@RequestBody RequestDepartment payload){
        return departmentService.createDepartment(payload);
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable Long id) throws Exception{
         departmentService.deleteDepartment(id);
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody @Valid RequestDepartment payload){
        return departmentService.updateDepartment(payload, id);
    }
}



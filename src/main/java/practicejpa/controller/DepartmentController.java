package practicejpa.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import practicejpa.payload.Department;
import practicejpa.payload.RequestDepartment;
import practicejpa.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/departments")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(@RequestBody RequestDepartment payload){
        return departmentService.saveDepartment(payload);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable Long id) throws Exception{
         departmentService.deleteDepartment(id);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody @Valid RequestDepartment payload){
        return departmentService.updateDepartment(payload, departmentId);
    }
}



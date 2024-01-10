package practicejpa.payload.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import practicejpa.domain.department.Department;
import practicejpa.payload.department.DepartmentRespone;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long studentId;
    private String studentName;
    private DepartmentRespone department;
}

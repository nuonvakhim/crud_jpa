package practicejpa.payload.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import practicejpa.payload.department.DepartmentResponse;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long stuId;

    private String stfName;

    private String stlName;

    private String stCourse;

    private String stContact;

    private String stBirthdate;

    private String stGender;
    private DepartmentResponse department;
}

package practicejpa.payload.student;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import practicejpa.payload.department.DepartmentResponse;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StudentResponse {
    private Long stuId;

    private String studentFirstName;

    private String studentLastName;

    private String studentCourse;

    private String studentContact;

    private String studentBirthdate;

    private String studentGender;
    private DepartmentResponse department;
}

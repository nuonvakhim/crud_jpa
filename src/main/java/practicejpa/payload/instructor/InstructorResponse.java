package practicejpa.payload.instructor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import practicejpa.payload.department.DepartmentResponse;


@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class InstructorResponse {
    private Long instructorId;
    private String instructorName;
    private DepartmentResponse department;

}

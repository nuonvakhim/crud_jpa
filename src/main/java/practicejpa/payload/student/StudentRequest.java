package practicejpa.payload.student;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StudentRequest {

    @NotBlank
    private String studentName;
    @NotBlank
    private String departmentName;
    @NotBlank
    private String departmentAddress;
    @NotBlank
    private String departmentCode;

    @Builder
    public StudentRequest(String studentName, String departmentName, String departmentAddress, String departmentCode) {
        this.studentName = studentName;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }
}

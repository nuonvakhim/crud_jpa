package practicejpa.payload.student;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StudentRequest {


    private String stfName;

    private String stlName;

    private String stCourse;

    private String stContact;

    private String stBirthdate;

    private String stGender;
    @NotNull
    private Long departmentId;

    @Builder
    public StudentRequest(String stfName, String stlName, String stCourse, String stContact, String stBirthdate, String stGender, Long departmentId) {
        this.stfName = stfName;
        this.stlName = stlName;
        this.stCourse = stCourse;
        this.stContact = stContact;
        this.stBirthdate = stBirthdate;
        this.stGender = stGender;
        this.departmentId = departmentId;
    }
}

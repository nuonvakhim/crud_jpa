package practicejpa.payload.instructor;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class InstructorRequest {

    @NotBlank
    private String instructorName;
    @NotNull
    private Long departmentId;
//    @NotNull
//    private String departmentName;
//    @NotBlank
//    private String departmentAddress;
//    @NotBlank
//    private String departmentCode;
    @Builder
    public InstructorRequest(String instructorName, Long departmentId) {
        this.instructorName = instructorName;
        this.departmentId = departmentId;
    }
    //    public InstructorRequest(String instructorName, String departmentName, String departmentAddress, String departmentCode) {
//        this.instructorName = instructorName;
//        this.departmentName = departmentName;
//        this.departmentAddress = departmentAddress;
//        this.departmentCode = departmentCode;

}

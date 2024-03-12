package practicejpa.payload.department;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RequestDepartment {
    @NotBlank
    private String dpName;

    @NotBlank
    private String dpAddr;

    @NotBlank
    private String dpCode;

    @Builder
    public RequestDepartment(String dpName, String dpAddr, String dpCode) {
        this.dpName = dpName;
        this.dpAddr = dpAddr;
        this.dpCode = dpCode;
    }
}

package practicejpa.payload.department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {
    private Long dpId;
    private String dpName;
    private String dpAddr;
    private String dpCode;
}



package practicejpa.payload.department;

import lombok.Builder;

@Builder
public record DepartmentRespone(
        String departmentName,
         String departmentAddress,
         String departmentCode
) {
}

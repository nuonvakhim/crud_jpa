package practicejpa.payload.department;

import lombok.Builder;

@Builder
public record DepartmentRespone(
        Long departmentId,
        String departmentName,
         String departmentAddress,
         String departmentCode
) {
}

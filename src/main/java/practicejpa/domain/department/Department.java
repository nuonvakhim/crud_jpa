package practicejpa.domain.department;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practicejpa.payload.department.DepartmentResponse;

import java.io.Serializable;

@Entity
@Data
@Table( name = "tb_department")
@NoArgsConstructor
@Builder
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long dpId;

    @Column(name = "dp_name")
    private String dpName;

    @Column(name = "dp_addr")
    private String dpAddr;

    @Column(name = "dp_code")
    private String dpCode;

    public DepartmentResponse departmentResponse(){
        return new DepartmentResponse( dpId, dpName, dpAddr ,dpCode);
    }
    @Builder
    public Department(Long dpId, String dpName, String dpAddr, String dpCode) {
        this.dpId = dpId;
        this.dpName = dpName;
        this.dpAddr = dpAddr;
        this.dpCode = dpCode;
    }
}

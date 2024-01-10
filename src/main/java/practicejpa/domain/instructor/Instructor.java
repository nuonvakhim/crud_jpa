package practicejpa.domain.instructor;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import practicejpa.domain.department.Department;
import practicejpa.payload.student.StudentResponse;

@Entity
@Table( name="instructor")
@Setter
@Getter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;
    private String instructorName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
    public StudentResponse toInstructorResponse() {
        return new StudentResponse(instructorId, instructorName, department.departmentRespone());
    }

    @Builder

    public Instructor(Long instructorId, String instructorName, Department department) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.department = department;
    }
}

package practicejpa.domain.student;

import jakarta.persistence.*;
import lombok.*;
import practicejpa.domain.department.Department;
import practicejpa.payload.student.StudentResponse;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String studentName;

    @ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public StudentResponse toStudentRespones() {
        return new StudentResponse(studentId, studentName, department.departmentRespone());
    }

    @Builder
    public Student(Long studentId, String studentName, Department department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
    }
}

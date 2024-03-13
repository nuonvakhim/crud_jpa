package practicejpa.domain.course;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import practicejpa.domain.department.Department;

@Entity
@Table(name="tb_course")
@Setter
@Getter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "dp_id")
    private Department department;

}

package practicejpa.domain.enrollment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import practicejpa.domain.course.Course;
import practicejpa.domain.student.Student;

@Entity
@Table( name= "tb_enrollment")
@Setter
@Getter
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn( name = "course_id")
    private Course course;
}

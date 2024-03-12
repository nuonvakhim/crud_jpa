package practicejpa.domain.student;

import jakarta.persistence.*;
import lombok.*;
import practicejpa.domain.department.Department;
import practicejpa.payload.student.StudentResponse;

@Entity
@Table(name = "tb_student")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long stuId;

    @Column(name = "stf_name")
    private String stfName;

    @Column(name = "stl_name")
    private String stlName;

    @Column(name = "st_course")
    private String stCourse;

    @Column(name = "st_cont")
    private String stContact;

    @Column(name = "st_bd")
    private String stBirthdate;

    @Column(name = "st_gen")
    private String stGender;

    @ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Department department;

    public StudentResponse toStudentResponse() {
        return new StudentResponse(stuId, stfName,stlName ,stCourse, stContact, stBirthdate,stGender, department.departmentResponse());
    }
@Builder
    public Student(Long stuId, String stfName, String stlName, String stCourse, String stContact, String stBirthdate, String stGender, Department department) {
        this.stuId = stuId;
        this.stfName = stfName;
        this.stlName = stlName;
        this.stCourse = stCourse;
        this.stContact = stContact;
        this.stBirthdate = stBirthdate;
        this.stGender = stGender;
        this.department = department;
    }
}

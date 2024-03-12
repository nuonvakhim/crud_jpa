package practicejpa.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practicejpa.domain.department.Department;
import practicejpa.domain.department.DepartmentRepository;
import practicejpa.domain.student.Student;
import practicejpa.domain.student.StudentRepository;
import practicejpa.payload.student.StudentRequest;
import practicejpa.payload.student.StudentResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public Student createStudent(StudentRequest payload) {

//        var de = Department.builder()
//                .departmentId(payload.getDepartmentId())
//                .departmentAddress(payload.getDepartmentAddress())
//                .departmentName(payload.getDepartmentName())
//                .departmentCode(payload.getDepartmentCode())
//                .build();

        var stu = Student.builder()
                .stfName(payload.getStfName())
                .department(departmentRepository.findById(payload.getDepartmentId()).get())
                .build();

        return studentRepository.save(stu);
    }

    @Override
    public List<StudentResponse> getStudents() {
        List<Student>students=studentRepository.findAll();
        return students.stream()
                .map(Student::toStudentResponse)
                .collect(Collectors.toList());
//        return null;
    }

    @Transactional
    @Override
    public Student updateStudent(StudentRequest payload, Long studentId) {
        var id = studentRepository.findById(studentId).
            orElseThrow(()-> new RuntimeException("Not found this ID"));

        id.setStfName(payload.getStfName());
        id.setDepartment(Department.builder()
                        .dpId(payload.getDepartmentId())
                        .build());
        return studentRepository.save(id);
    }

    @Override
    public void deleteStudent(Long id) {
        var delById = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Id Not Found"));
        studentRepository.deleteById(delById.getStuId());
    }

    @Override
    public StudentResponse getById(Long id) {
//        return  null;
        return studentRepository.findById(id).orElseThrow(()->new RuntimeException("ID not Found")).toStudentResponse();
    }

}

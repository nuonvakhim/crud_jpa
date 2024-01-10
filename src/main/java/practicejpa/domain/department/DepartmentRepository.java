package practicejpa.domain.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicejpa.domain.department.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


}

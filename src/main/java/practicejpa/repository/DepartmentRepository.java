package practicejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practicejpa.payload.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {


}

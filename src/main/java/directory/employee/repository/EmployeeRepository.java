// EmployeeRepository.java
package directory.employee.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import directory.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}

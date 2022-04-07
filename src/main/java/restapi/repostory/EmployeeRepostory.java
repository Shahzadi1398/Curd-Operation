package restapi.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import restapi.model.Employee;

public interface EmployeeRepostory extends JpaRepository<Employee, Long> {
}
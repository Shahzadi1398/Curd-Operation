package restapi.service;

import restapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getByid(long id);

    void save(Employee employee);

    Employee update(long id, Employee employee);

    void deleteEmployee(long id);
}                                                 
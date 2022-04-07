package restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restapi.model.Employee;
import restapi.repostory.EmployeeRepostory;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepostory repostory;

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) repostory.findAll();
    }

    @Override
    public Employee getByid(long id) {
        return repostory.findById(id).get();
    }

    @Override
    public void save(Employee employee) {
        repostory.save(employee);
    }

    @Override
    public Employee update(long id, Employee employee) {
        Employee employeeId = repostory.findById(id).get();
        employeeId.setFirstName(employee.getFirstName());
        employeeId.setLastName(employee.getLastName());
        employeeId.setAddress(employee.getAddress());

        repostory.save(employeeId);
        return employeeId;

    }

    @Override
    public void deleteEmployee(long id) {
        repostory.deleteById(id);

    }
}

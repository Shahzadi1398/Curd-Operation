package restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import restapi.model.Employee;
import restapi.service.EmployeeService;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*" , maxAge = 3600)
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/save")
    public String save(@RequestBody Employee employee) {
        service.save(employee);
        return "Hi " +employee.getFirstName() + " your data is saved";
    }

    @GetMapping("/list")
    public List<Employee> list() {
        return service.getAllEmployee();
    }

    @GetMapping("/list/{id}")
    public Employee getbyId(@PathVariable long id) {
        return service.getByid(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        service.deleteEmployee(id);
        return "Deleted successfully id = " + id;
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable("id") long id,@RequestBody Employee employee){
        service.update(id,employee);
        return "Updated successfully id = " +id;
    }

}

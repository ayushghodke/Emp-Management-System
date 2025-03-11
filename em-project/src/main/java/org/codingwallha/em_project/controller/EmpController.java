package org.codingwallha.em_project.controller;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.codingwallha.em_project.model.Employee;
import org.codingwallha.em_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
@RestController
public class EmpController {
   //List<Employee> employees=new ArrayList<>();
    @Autowired
    EmployeeService employeeService;  //Dependency injuction

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {      
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.readEmployee(id);
    }   

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {               
        return employeeService.createEmployee(employee);
    }
    
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id)
    {
        if(employeeService.deleteEmployee(id))
        {
            return "Deleted Successfully";
        }
         return "not found";
    }  

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        //TODO: process PUT request        
        return employeeService.updateEmployee(id, employee);
    }
}

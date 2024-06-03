package priv.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.backend.entity.PageBean;
import priv.backend.entity.RestBean;
import priv.backend.entity.dto.Employee;
import priv.backend.service.EmployeeService;
import priv.backend.utils.ReturnUtils;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public RestBean<Object> getAllEmployees(PageBean pageBean) {
        return ReturnUtils.messageData(employeeService::getAllEmployees, pageBean);
    }

    @PostMapping("/add")
    public RestBean<Void> addEmployee(@RequestBody Employee employee) {
        return ReturnUtils.message(employeeService::addEmployee, employee);
    }

    @DeleteMapping("/delete/{id}")
    public RestBean<Void> deleteEmployee(@PathVariable("id") Integer id) {
        return ReturnUtils.message(employeeService::deleteEmployee, id);
    }

    @PutMapping("/update")
    public RestBean<Void> updateEmployee(@RequestBody Employee employee) {
        return ReturnUtils.message(employeeService::updateEmployee, employee);
    }


    @GetMapping("/get/{id}")
    public RestBean<Object> getEmployee(@PathVariable("id") Integer id) {
        return ReturnUtils.messageData(() -> employeeService.getEmployeeById(id));
    }

    @GetMapping("/getAll")
    public RestBean<Object> getEmployees() {
        return ReturnUtils.messageData(employeeService::getEmployees);
    }

    @PostMapping("/search")
    public RestBean<Object> searchEmployee(@RequestBody Employee employee) {
        return ReturnUtils.messageData(() -> employeeService.searchEmployee(employee));
    }
}

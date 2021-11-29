package com.application.controller;

import com.application.entity.Employee;
import com.application.repo.EmployeeRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeDataController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @GetMapping("/allEmployee")
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployee(@PathVariable("empId") Integer empId){
        return employeeRepo.findById(empId).get();
    }

    @DeleteMapping("/remove/{empId}")
    public String delEmployee(@PathVariable("empId") Integer empId){
        JSONObject jo = new JSONObject( employeeRepo.findById(empId).get());
        employeeRepo.deleteById(empId);
        return "Deleted Employee number: "+ empId +"\n" + jo;
    }

    @PatchMapping("/update/{empId}")
    public Employee updateEmployee(@PathVariable("empId") Integer empId, @RequestBody Employee employee){
        Employee employeeFound =  employeeRepo.findById(empId).get();
        employeeFound.setName(employee.getName());
        employeeFound.setAge(employee.getAge());
        employeeFound.setSalary(employee.getSalary());
        employeeFound.setEmail(employee.getEmail());
        employeeFound.setContact(employee.getContact());
        employeeFound.setDepartment(employee.getDepartment());
        return employeeRepo.save(employeeFound);

    }
}




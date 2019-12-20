package com.ibsu.demo.controllers;

import com.ibsu.demo.dto.AddEditEmployee;
import com.ibsu.demo.entities.Employee;
import com.ibsu.demo.services.EmployeeService;
import com.ibsu.demo.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST,
            produces = {"application/json"}
        )
    @ResponseBody
    public Employee addEmployee(@RequestBody AddEditEmployee addEditEmployee) throws Exception {
        GeneralUtil.checkRequiredProperties(addEditEmployee,
                Arrays.asList("firstName", "lastName", "hireDate",
                        "email", "departmentId"));
        return employeeService.addEmployee(addEditEmployee);
    }

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json"}
            )
    @ResponseBody
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"}
    )
    @ResponseBody
    public Employee getEmployee(@PathVariable Long id) throws Exception {
        return employeeService.find(id);
    }

    @RequestMapping(
            value = "/edit",
            method = RequestMethod.PUT,
            produces = {"application/json"}
    )
    @ResponseBody
    public Employee editEmployee(@RequestBody AddEditEmployee addEditEmployee) throws Exception {
        GeneralUtil.checkRequiredProperties(addEditEmployee,
                Arrays.asList("employeeId", "firstName", "lastName",
                        "hireDate", "email", "departmentId"));
        return employeeService.editEmployee(addEditEmployee);
    }

}

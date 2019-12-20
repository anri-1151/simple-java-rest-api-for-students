package com.ibsu.demo.controllers;

import com.ibsu.demo.dto.AddEditDepartment;
import com.ibsu.demo.dto.SearchDepByName;
import com.ibsu.demo.entities.Department;
import com.ibsu.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json"}
    )
    @ResponseBody
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"}
    )
    @ResponseBody
    public Department getOne(@PathVariable Long id) throws Exception {
        return departmentService.getDeparmentById(id);
    }

    @RequestMapping(
            value = "/search",
            method = RequestMethod.POST,
            produces = {"application/json"}
    )
    @ResponseBody
    public List<Department> search(
            @RequestBody SearchDepByName searchDepByName
            ) {
        return departmentService.getByName(searchDepByName.getName());
    }

    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST,
            produces = {"application/json"}
    )
    @ResponseBody
    public Department addDepartment(@RequestBody AddEditDepartment addEditDepartment) {
        return departmentService.addDepartment(addEditDepartment);
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST,
            produces = {"application/json"}
    )
    @ResponseBody
    public Department updateDepartment(@RequestBody AddEditDepartment addEditDepartment) throws Exception {
        return departmentService.editDepartment(addEditDepartment);
    }
}

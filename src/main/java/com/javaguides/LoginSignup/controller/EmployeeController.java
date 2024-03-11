package com.javaguides.LoginSignup.controller;

import com.javaguides.LoginSignup.dto.EmployeeDto;
import com.javaguides.LoginSignup.dto.LoginDto;
import com.javaguides.LoginSignup.response.LoginResponse;
import com.javaguides.LoginSignup.service.EmployeeService;

import org.springframework.http.ResponseEntity;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public String addEmployee(@RequestBody EmployeeDto employeeDto){
        String id = employeeService.addEmployee(employeeDto);
        return id;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDto loginDto) {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
    
}

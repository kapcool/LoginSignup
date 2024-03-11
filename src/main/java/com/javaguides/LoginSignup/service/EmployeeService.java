package com.javaguides.LoginSignup.service;

import com.javaguides.LoginSignup.dto.LoginDto;
import com.javaguides.LoginSignup.response.LoginResponse;
import com.javaguides.LoginSignup.dto.EmployeeDto;

public interface EmployeeService {

    String addEmployee(EmployeeDto employeeDto);
    LoginResponse loginEmployee(LoginDto loginDto);
}

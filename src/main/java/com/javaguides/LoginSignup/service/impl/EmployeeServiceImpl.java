package com.javaguides.LoginSignup.service.impl;

import com.javaguides.LoginSignup.dto.EmployeeDto;
import com.javaguides.LoginSignup.dto.LoginDto;
import com.javaguides.LoginSignup.entity.Employee;
import com.javaguides.LoginSignup.repository.EmployeeRepository;
import com.javaguides.LoginSignup.response.LoginResponse;
import com.javaguides.LoginSignup.service.EmployeeService;
import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDto employeeDto) {


        Employee employee = new Employee(
                employeeDto.getEmployeeId(),
                employeeDto.getEmployeeName(),
                employeeDto.getEmail(),
                this.passwordEncoder.encode(employeeDto.getPassword())
        );

        employeeRepository.save(employee);
        return employee.getEmployeeName();
    }

    @Override
    public LoginResponse loginEmployee(LoginDto loginDto) {
        String msg = "";
        Employee employeeFetchedWithEmail = employeeRepository.findByEmail(loginDto.getEmail());

        if(employeeFetchedWithEmail!=null){
            String pass = employeeFetchedWithEmail.getPassword();
            String password = loginDto.getPassword();

            Boolean isPwdRight = passwordEncoder.matches(pass, password);
            if(isPwdRight){
                Optional<Employee> employee = employeeRepository.findOneByEmailAndPassword(loginDto.getEmail(), pass);

                if(employee.isPresent()){
                    return new LoginResponse("Login Success", true);
                }
                else{
                    return new LoginResponse("Login Failed", false);
                }
            }
            else{
                return new LoginResponse("Password Did not match", false);
            }
        }
        else{
            return new LoginResponse("Email does not exist", false);
        }
    }
}

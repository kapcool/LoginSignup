package com.javaguides.LoginSignup.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long employeeId;
    private String employeeName;
    private String email;
    private String password;
}

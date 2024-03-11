package com.javaguides.LoginSignup.entity;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @Column(name="employee_Id", length=45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name="employee_name", length=255)
    private String employeeName;

    @Column(name="email", length=255)
    private String email;

    @Column(name="password", length=255)
    private String password;

}

package com.seminar.demo.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long empNo;
    private String firstName;
    private String lastName;
    private Long salary;
}

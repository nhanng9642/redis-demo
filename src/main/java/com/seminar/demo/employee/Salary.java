package com.seminar.demo.employee;

import jakarta.persistence.*;

@Entity
@Table(name = "salaries")
public class Salary {
    private Long salary;

    @Id
    private String fromDate;

    private String toDate;

    @Id
    @JoinColumn(name = "emp_no")
    @ManyToOne()
    Employee employee;
}

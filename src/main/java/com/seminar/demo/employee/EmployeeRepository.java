package com.seminar.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = """
            SELECT
                new com.seminar.demo.employee.EmployeeDTO(
                    e.id,
                    e.firstName,
                    e.lastName,
                    s.salary
                )
            FROM
                Employee e
            JOIN e.salary s
            WHERE
                s.toDate = '9999-01-01'
            ORDER BY
                s.salary DESC
            LIMIT :size
        """)
    List<EmployeeDTO> getTopSalaryEmployee(int size);
}

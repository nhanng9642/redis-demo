package com.seminar.demo.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Cacheable(value = "employee", key = "#id")
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElse(null);
    }

    @Cacheable(value = "employee", key = "#employee.id")
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @CacheEvict(value = "employee", key = "#id")
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Delete employee with id " + id + " successfully";
    }

    @CachePut(value = "employee", key = "#id")
    public Employee updateEmployee(Employee employee, Long id) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Cacheable(value = "employee", key = "#size")
    public List<EmployeeDTO> getTopSalary(int size) {
        return employeeRepository.getTopSalaryEmployee(size);
    }

    @Cacheable(value = "employees", key = "#page.pageNumber")
    public List<Employee> getAllEmployees(Pageable page) {
        return employeeRepository.findAll(page).getContent();
    }
}

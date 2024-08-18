package com.bankiapp.services;



import com.bankiapp.dto.EmployeeDto;
import com.bankiapp.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeDto dto);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee affecterEmployeeAUnGroup(EmployeeDto dto);
    List<Employee> getAllEmployeesByGroupId(long id);
}

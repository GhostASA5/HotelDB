package com.project.HotelBooking.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.HotelBooking.dto.EmployeeDto;
import com.project.HotelBooking.entity.employee.Employee;
import com.project.HotelBooking.entity.employee.EmployeeRole;
import com.project.HotelBooking.repository.EmployeeRepository;
import com.project.HotelBooking.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final ObjectMapper objectMapper;

    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = objectMapper.convertValue(employeeDto, Employee.class);
        employee.setRole(EmployeeRole.valueOf(employeeDto.getRole()));
        return repository.save(employee);
    }

    public void deactivateEmployee(Long employeeId) {
        repository.deactivateEmployee(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee existingEmployee = getEmployeeById(id);
        Employee newEmployee = objectMapper.convertValue(employeeDto, Employee.class);
        BeanUtils.copyNonNullProperties(newEmployee, existingEmployee);
        return repository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}

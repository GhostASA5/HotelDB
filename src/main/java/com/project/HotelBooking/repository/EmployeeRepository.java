package com.project.HotelBooking.repository;

import com.project.HotelBooking.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Procedure(procedureName = "deactivate_employee")
    void deactivateEmployee(@Param("p_employee_id") Long employeeId);
}

package com.example.employee_management_system.repository;


import com.example.employee_management_system.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface DashboardRepository extends JpaRepository<Employee, Long> {



    // Total Employees
    @Query("SELECT COUNT(e) FROM Employee e")
    long countEmployees();



    // Total Departments
    @Query("SELECT COUNT(DISTINCT e.department) FROM Employee e")
    long countDepartments();



    // Employees on Approved Leave
    @Query("SELECT COUNT(l) FROM Leave l WHERE l.status = 'APPROVED'")
    long countEmployeesOnLeave();



    // Total Salary Paid
    @Query("SELECT COALESCE(SUM(p.netSalary),0) FROM Payroll p")
    double totalSalaryPaid();



    // Average Salary
    @Query("SELECT COALESCE(AVG(p.netSalary),0) FROM Payroll p")
    double averageSalary();



    // Employees Present Today
    @Query("SELECT COUNT(a) FROM Attendance a WHERE a.status = 'PRESENT' AND a.date = CURRENT_DATE")
    long countPresentToday();


}

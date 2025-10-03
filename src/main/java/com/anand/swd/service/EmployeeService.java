package com.anand.swd.service;

import com.anand.swd.bean.Employee;

import java.util.List;

public interface EmployeeService {
    void lessThan(List<Employee> employeeList);
    void moreThan(List<Employee> employeeList);
    void longReportingLine(List<Employee> employeeList, int threshold);
}

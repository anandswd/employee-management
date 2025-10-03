package com.swiss.re.service;

import com.swiss.re.bean.Employee;
import com.swiss.re.utils.EmployeeUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class EmployeeServiceImplTest {
    private EmployeeService employeeService;
    @Before
    public void setUp() throws Exception {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void lessThan() throws IOException {
        String path= System.getProperty("user.dir");
        List<Employee> employeeList = EmployeeUtils.getEmployeeList(path+"/src/test/resources/employee.csv");
        employeeService.lessThan(employeeList);

    }

    @Test
    public void moreThan() throws IOException {
        String path= System.getProperty("user.dir");
        List<Employee> employeeList = EmployeeUtils.getEmployeeList(path+"/src/test/resources/employee.csv");
        employeeService.moreThan(employeeList);
    }

    @Test
    public void longReportingLine() throws IOException {
        String path= System.getProperty("user.dir");
        List<Employee> employeeList = EmployeeUtils.getEmployeeList(path+"/src/test/resources/employee.csv");
        employeeService.longReportingLine(employeeList,1);
    }
}
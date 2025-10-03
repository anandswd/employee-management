package com.swiss.re.service;

import com.swiss.re.bean.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public void lessThan(List<Employee> employeeList) {
        Map<String,List<Employee>> managerList = employeeList.stream().filter(employee -> employee.getMangerId()!=null).collect(Collectors.groupingBy(Employee::getMangerId));
        Map<String,Employee>  employeeMap = employeeList.stream().collect(Collectors.toMap(Employee::getId,employee -> employee));
        System.out.println("Employee Details who earn less than they should and by amount");
        System.out.println("***************************************************************");
        managerList.forEach((key, value) -> {
            double maxSalary = value.stream().mapToDouble(Employee::getSalary).max().orElse(0);
            Employee manager = employeeMap.get(key);
            if (manager.getSalary() <= maxSalary) {
                System.out.println(manager.toString() + " by amount: "+ (maxSalary - manager.getSalary()));
            }
        });
        System.out.println("***********************END LESS THAN****************************************");
    }

    @Override
    public void moreThan(List<Employee> employeeList) {
        Map<String,List<Employee>> managerList = employeeList.stream().filter(employee -> employee.getMangerId()!=null).collect(Collectors.groupingBy(Employee::getMangerId));
        Map<String,Employee>  employeeMap = employeeList.stream().collect(Collectors.toMap(Employee::getId,employee -> employee));
        System.out.println("Employee Details who earn more than they should and by amount");
        System.out.println("***************************************************************");
        managerList.forEach((key, value) -> {
            double maxSalary = value.stream().mapToDouble(Employee::getSalary).max().orElse(0);
            Employee manager = employeeMap.get(key);
            if (manager.getSalary() >= maxSalary) {
                System.out.println(manager.toString() + " by amount: "+ (manager.getSalary() - maxSalary));
            }
        });
        System.out.println("***********************END MORE THAN****************************************");
    }

    @Override
    public void longReportingLine(List<Employee> employeeList, int threshold) {
        Map<String,Employee>  employeeMap = employeeList.stream().collect(Collectors.toMap(Employee::getId,employee -> employee));
        System.out.println("Employee Details who have a reporting line which is too long, and by how much");
        System.out.println("***************************************************************");
        employeeList.forEach(employee -> {
            int depth = getDepth(employee, employeeMap);
            if (depth > threshold) {
                System.out.println(employee.toString() +" and by "+ (depth - threshold) );
            }
        });
        System.out.println("****************END OF REPORTING DEPTH LINE***********************************************");
    }
    private int getDepth(Employee employee, Map<String, Employee> employeeMap) {
        int depth = 0;
        Employee currentEmployee = employee;
        while (currentEmployee.getMangerId() != null) {
            depth++;
            currentEmployee = employeeMap.get(currentEmployee.getMangerId());
        }
        return depth;
    }
}

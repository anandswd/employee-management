package com.swiss.re.mapper;

import com.swiss.re.bean.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {
    /*
    The method is used to mapping List to Employee
     */
    public List<Employee> maptoEmployee(List<List<String>> lists){
        return lists.stream().skip(1).map(data->{
            Employee employee = new Employee();
            employee.setId(data.get(0));
            employee.setFirstName(data.get(1));
            employee.setLastName(data.get(2));
            employee.setSalary(Double.valueOf(data.get(3)));
            if(data.size()>4){
                employee.setMangerId(data.get(4));
            }
            return employee;
        }).collect(Collectors.toList());
    }
}

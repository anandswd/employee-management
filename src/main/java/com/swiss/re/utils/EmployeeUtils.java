package com.swiss.re.utils;

import com.swiss.re.bean.Employee;
import com.swiss.re.mapper.EmployeeMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeUtils {
    private static final String COMMA_DELIMITER = ",";
    /*
    The method is used to read the given csv file and convert into List
     */
    public static List<List<String>> readFile(String file) throws IOException {
        Optional<List<List<String>>> records = Optional.empty();
        try (Stream<String> lines = Files.lines(Paths.get(file))) {
            records  = Optional.of(lines.map(line -> Arrays.asList(line.split(COMMA_DELIMITER)))
                    .collect(Collectors.toList()));
        }
        return records.get();
    }
    /*
    The method is used to get the Employee list after mapping list to Employee beans
     */
    public static List<Employee> getEmployeeList(String file) throws IOException {
        return new EmployeeMapper().maptoEmployee(readFile(file));
    }
}

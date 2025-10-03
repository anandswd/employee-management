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
    public static List<List<String>> readFile(String file) throws IOException {
        Optional<List<List<String>>> records = Optional.empty();
        try (Stream<String> lines = Files.lines(Paths.get(file))) {
            records  = Optional.of(lines.map(line -> Arrays.asList(line.split(COMMA_DELIMITER)))
                    .collect(Collectors.toList()));
        }
        return records.get();
    }

    public static List<Employee> getEmployeeList(String file) throws IOException {
        return new EmployeeMapper().maptoEmployee(readFile(file));
    }
}

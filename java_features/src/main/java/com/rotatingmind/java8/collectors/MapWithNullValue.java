package com.rotatingmind.java8.collectors;

import com.rotatingmind.model.Department;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapWithNullValue {

    public static void main(String[] args) {
        List< Department > deptList = new ArrayList<Department>();
        deptList.add(new Department(1, "IT", new BigDecimal(1)));
        deptList.add(new Department(2, "HR", new BigDecimal(12)));
        deptList.add(new Department(3, null, null));
        deptList.add(new Department(4, "Development", new BigDecimal(56)));
        deptList.add(new Department(5, "Recruitment", new BigDecimal(7)));

        /*Map<Integer, String> mapValue = deptList.stream()
                .collect(Collectors.toMap(Department::getId, Department::getName));*/

        Map<Integer, BigDecimal> mapValue = deptList.stream()
                .collect(HashMap::new, (m, v)->m.put(v.getId(), v.getSize()), HashMap::putAll);

        System.out.println(mapValue);

        List<String> names = List.of("Sandeep", "Suresh", "Ramesh", "vivek");
        names.stream().anyMatch(name -> name.equals("vivek"));

    }
}

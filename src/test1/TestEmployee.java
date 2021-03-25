package test1;

import model.Employee;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestEmployee {

    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(
                new Employee(100l, "A", 21),
                new Employee(1001l, "B", 32),
                new Employee(1002l, "A", 33),
                new Employee(99l, "B", 10)
        );
        TestEmployee emp = new TestEmployee();
        List<Employee> employees = emp.sortByNameThenAge(emps);

        //employees.forEach(System.out::println);

        LocalDate a = LocalDate.of(2021, 2, 16);
        LocalDate b = LocalDate.of(2021, 2, 14);


        BigDecimal x = new BigDecimal(1.498609);
        x = x.setScale(8,  RoundingMode.HALF_UP);

        BigDecimal y = new BigDecimal(32.543211);
        y = y.setScale(8,  RoundingMode.HALF_UP);
        // System.out.println(BigDecimal.ONE.divide(y, 6, RoundingMode.HALF_UP));

        System.out.println("Add Default "+ x.add(y));
        MathContext ctx = new MathContext(0);
        System.out.println("Add -> custome "+ x.add(y, ctx));

        System.out.println("Scale => " + Math.max(x.scale(), y.scale()));
        System.out.println("Scale X "+ x.scale());

    }

    public List<Employee> sortByNameThenAge(List<Employee> emps) {
        Comparator<Employee> cmp1 = Comparator.comparingInt(Employee::getAge);
        Comparator<Employee> cmp2 = Comparator.comparing(Employee::getName);

        return emps.stream().sorted(cmp2.thenComparing(cmp1)).collect(Collectors.toList());
    }


}

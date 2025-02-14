package mapinterface.groupobjectsbyproperty;

import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> groupedMap = new HashMap<>();
        for (Employee emp : employees) {
            groupedMap.putIfAbsent(emp.department, new ArrayList<>());
            groupedMap.get(emp.department).add(emp);
        }
        return groupedMap;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> result = groupByDepartment(employees);
        System.out.println(result);
    }
}


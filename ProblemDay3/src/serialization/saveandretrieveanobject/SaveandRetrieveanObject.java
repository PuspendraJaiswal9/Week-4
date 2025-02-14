package serialization.saveandretrieveanobject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}

public class SaveandRetrieveanObject {
    public static void main(String[] args) {
        String fileName = "employees.ser";
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Rahul", "IT", 50000));
        employees.add(new Employee(2, "Priya", "HR", 45000));
        employees.add(new Employee(3, "Amit", "Finance", 60000));

        serializeEmployees(employees, fileName);
        List<Employee> retrievedEmployees = deserializeEmployees(fileName);

        System.out.println("Retrieved Employee Data:");
        for (Employee emp : retrievedEmployees) {
            emp.display();
        }
    }

    private static void serializeEmployees(List<Employee> employees, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    private static List<Employee> deserializeEmployees(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return employees;
    }
}


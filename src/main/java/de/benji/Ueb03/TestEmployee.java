package de.benji.Ueb03;

import java.util.Arrays;
import java.util.Scanner;

public class TestEmployee {
  public static void main(String[] args) {
    Employee employee1 = new Employee("Jürgen", 50000);
    Employee employee2 = new Employee("Hans");
    Employee employee3 = new Employee("Peter", 100000);
    Employee[] employees = {employee1, employee2, employee3};
    
    Scanner scanner = new Scanner(System.in);
    for(Employee employee : employees) {
      System.out.println("Enter salary for " + employee.getName());
      float salary = scanner.nextFloat();
      while (salary < 0 || salary > 50000) {
        System.out.println("Salary must be valid");
        salary = scanner.nextFloat();
      }
      employee.setSalary(salary);
    }
    
    float averageSalary = Arrays.stream(employees).map(Employee::getSalary).reduce(0f, Float::sum) / employees.length;
    System.out.println("Average salary: " + averageSalary);
  }
}

package de.benji.Ueb03;

public class Employee {
  private String name;
  private float salary;
  
  public Employee(String inputName, float inputSalary){
    name = inputName;
    salary = inputSalary;
  }
  
  public Employee(String inputName){
    this(inputName, 0);
  }
  
  public void setSalary(float salary) {
    if(salary < 0 || salary > 50000) {
      throw new IllegalArgumentException("Salary must be valid");
    }
    this.salary = salary;
  }
  
  public float getSalary() {
    return salary;
  }
  
  public String getName() {
    return name;
  }
  
  public String getInfo() {
    return "Name: " + name + ", Salary: " + salary;
  }
}

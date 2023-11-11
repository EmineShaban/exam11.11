package com.management;

 class Employee {
//(ID, name, department, role, salary)
private int id;
     private String name;
     private String department;
     private String role;

    private double salary;

     Employee(int id, String name, String department, String role, double salary) {
         this.id = id;
         this.name = name;
         this.department = department;
         this.role = role;
         this.salary = salary;

     }

     public double getSalary() {
         return salary;
     }

     public void setSalary(double salary) {
         this.salary = salary;
     }

     public String getRole() {
         return role;
     }

     public void setRole(String role) {
         this.role = role;
     }

     public String getDepartment() {
         return department;
     }

     public void setDepartment(String department) {
         this.department = department;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     @Override
     public String toString() {
         return "Id: " + id + ", Name: " + name + ", Department: " + department + ", Role: " + role + ", Salary: " + salary;
     }
 }

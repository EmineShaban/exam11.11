package com.management;

import java.io.IOException;
import java.util.List;

public class StaffManager {
    private List<Employee> employees;

    public StaffManager(List<Employee> employees) throws IOException {
        this.employees = employees;
    }

    public void viewAllEmployees() {
        System.out.println("Here you can see all employees:");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public void addEmployee(int id, String name, String department, String role, double salary) {
        System.out.println("You have successfully add new employee");
        employees.add(new Employee(id, name, department, role, salary));
    }

    public void editEmployee(int id, String name, String department, String role, double salary) {
        System.out.println("You have successfully edit employee");
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setDepartment(department);
                employee.setRole(role);
                employee.setSalary(salary);
                employee.setId(id);

            }
        }
    }

    public void fireEmployee(int id) {
        System.out.println("You have successfully fire employee");

        int counter = 0;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(counter);
                return;
            }
            counter = counter + 1;

        }
    }


    public void search(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                System.out.println(employee);
//                employees.remove(counter);
                return;
            }

        }
    }
}


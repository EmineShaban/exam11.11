package com.management;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StaffManagementApp {

    public static void main(String[] args) throws IOException {
        List<Employee> employees = new ArrayList<>();

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/macbook/IdeaProjects/exam11.11/src/com/management/data.csv")))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split("/n");
                String[] values = lines[0].split(",");
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                String department = values[2];
                String role = values[3];
                double salary = Double.parseDouble(values[4]);
                employees.add(new Employee(id, name, department, role, salary));
             }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Welcome to Staff Management System");
        boolean isRunning = true;
        while (isRunning) {
            displayCommands(employees);
        }
    }

    private static void displayCommands(List<Employee> employees) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StaffService service = new StaffService();
        StaffManager manager = new StaffManager(employees);
        System.out.println("Please, choose Add, Edit, Fire, List or Search");
        System.out.println("Add Employee");
        System.out.println("Edit Employee");
        System.out.println("Fire Employees");
        System.out.println("List of Employees");
        System.out.println("Search by name");
        System.out.println("Exit");
        String choice = scanner.nextLine();
        switch (choice) {
            case "Add":
                System.out.println("Please enter id, name, department, role, salary");
                String newEmployee = scanner.nextLine();
                String[] values = newEmployee.split(", ");
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                String department = values[2];
                String role = values[3];
                double salary = Double.parseDouble(values[4]);
                manager.addEmployee(id, name, department, role, salary);
                service.writer(employees);
                break;
            case "Edit":
                System.out.println("Please enter id, name, department, role, salary");
                String newEmployeeEdit = scanner.nextLine();
                String[] valuesEdit = newEmployeeEdit.split(", ");
                int id1 = Integer.parseInt(valuesEdit[0]);
                String name1 = valuesEdit[1];
                String department1 = valuesEdit[2];
                String role1 = valuesEdit[3];
                double salary1 = Double.parseDouble(valuesEdit[4]);
                manager.editEmployee(id1, name1, department1, role1, salary1);
                service.writer(employees);
                break;
            case "Fire":
                System.out.println("Please enter id");
                int idFire = Integer.parseInt(scanner.nextLine());
                manager.fireEmployee(idFire);
                service.writer(employees);
                break;
            case "List":
                manager.viewAllEmployees();
                break;
            case "Search":
                System.out.println("Please enter name of employee");
                String nameSearch = scanner.nextLine();
                manager.search(nameSearch);
                break;
            case "Exit":
                System.out.println("Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Something going wrong! Choose 1 or 2!");
        }
    }

}
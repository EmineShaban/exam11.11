package com.management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StaffService {
    public void writer(List<Employee> employees) {
        String fileName = "/Users/macbook/IdeaProjects/exam11.11/src/com/management/data.csv";
        String content = "";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (Employee employee : employees) {
                content += employee.getId() + "," + employee.getName() + "," + employee.getDepartment() + "," + employee.getRole() + "," + employee.getSalary() + "\n";
            }
            fileWriter.write(content);
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}

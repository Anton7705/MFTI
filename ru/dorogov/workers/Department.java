package ru.dorogov.workers;

import java.util.ArrayList;
import java.util.List;

// 1.6.11
// 4.2.1
public class Department {
    String name;
    Employee head;
    List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        if (employee != null) {
            employee.setDepartment(this);
            this.employees.add(employee);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public Employee getHead() {
        return head;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHead(Employee head) {
        if (head != null) {
            head.setDepartment(this);
        }
        this.head = head;
    }
}

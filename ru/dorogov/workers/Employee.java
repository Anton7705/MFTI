package ru.dorogov.workers;

// 1.6.11
// 4.2.1
public class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this(name);
        this.setDepartment(department);
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Department department) {
        if (department == this.department) return;
        if (this.department != null && this == this.department.head) this.department.head = null;
        if (this.department != null) {
            this.department.employees.remove(this);
        }
        this.department = department;
        if (department != null) {
            department.employees.add(this);
        }
    }

    @Override
    public String toString() {
        if (this == department.head) {
            return name + " начальник отдела " + department.name;
        } else if (department.name == null || department.head == null) {
            return "У сотрудника " + name + " работающего в отделе " + department.name + " нет начальника";
        }
        return name + " работает в отделе " + department.name + ", начальник которого " + department.head.name;
    }
}


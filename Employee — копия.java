// 1.6.11
public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        if (this == department.getHead()) {
            return name + " начальник отдела " + department.getName();
        } else {
            return name + " работает в отделе " + department.getName() + ", начальник которого " + department.getHead().getName();
        }
    }
}




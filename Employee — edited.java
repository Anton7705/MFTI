import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1.6
class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        department.addEmployee(this);
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
        if ( department == this.department) return;
        if (department != null && this == department.getHead()) this.department.setHead(null);
        if (this.department != null) {
            this.department.getEmployees().remove(this);
        }
        this.department = department;
        if (department != null) {
            department.addEmployee(this);
        }
    }

    @Override
    public String toString() {
        if (this == department.getHead()) {
            return name + " начальник отдела " + department.getName();
        } else if (department.getName() == null || department.getHead() == null) {
            return "У сотрудника " + name + " работающего в отделе " + department.getName() + " нет начальника";
        }
        return name + " работает в отделе " + department.getName() + ", начальник которого " + department.getHead().getName();
    }
}



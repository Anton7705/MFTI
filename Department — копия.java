// 1.6.11
class Department {
    private String name;
    private Employee head;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        if (head.getDepartment() != this) {
            throw new IllegalArgumentException("Начальник должен работать в том же отделе, которым он руководит.");
        }
        this.head = head;
    }
}


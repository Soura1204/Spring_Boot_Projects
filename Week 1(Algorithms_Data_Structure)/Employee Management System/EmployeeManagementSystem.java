import java.util.Arrays;

class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
            System.out.println("Employee added: " + employee);
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i] = employees[size - 1]; 
                employees[size - 1] = null; 
                size--;
                System.out.println("Employee deleted: " + employeeId);
                return;
            }
        }
        System.out.println("Employee not found: " + employeeId);
    }

    public void traverseEmployees() {
        System.out.println("Employee List:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        
        ems.addEmployee(new Employee(1, "Sourajit", "Developer", 70000));
        ems.addEmployee(new Employee(2, "Sayak", "Designer", 65000));
        ems.addEmployee(new Employee(3, "Messi", "Manager", 90000));
        ems.addEmployee(new Employee(4, "Tanmay", "Analyst", 60000));
        ems.addEmployee(new Employee(5, "Yamal", "HR", 50000));

        
        ems.traverseEmployees();

        
        int searchId = 3;
        Employee found = ems.searchEmployee(searchId);
        if (found != null) {
            System.out.println("Employee found: " + found);
        } else {
            System.out.println("Employee not found: " + searchId);
        }

        
        int deleteId = 2;
        ems.deleteEmployee(deleteId);

        
        ems.traverseEmployees();
    }
}

package softuni.advanced.examprep.Openning.src.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {

    private String name;
    private int capacity;

    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public void add(Employee employee) {
        if (this.capacity > this.employees.size()) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        if (this.employees.contains(name)) {
            employees.remove(name);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee employee = null;

        for (Employee e : employees) {
            if (employee == null || employee.getAge() < e.getAge()) {
                employee = e;
            }
        }
        return employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(String name) {
        for (Employee e : employees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Employees working at Bakery " + this.name + ":");

        for (Employee e : employees) {
            sb.append(System.lineSeparator());
            sb.append(e.toString());
        }
        return sb.toString();
    }
}

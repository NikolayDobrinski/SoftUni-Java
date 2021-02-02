package softuni.advanced.definingclasses.CompanyRoster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {

    private String name;
    private List<Employee> employeeList;

    public Department() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public double getAverageSalary() {
        double avgSalary = 0.0;
        for (Employee employee: this.employeeList) {
            avgSalary += employee.getSalary();
        }
        return avgSalary / this.employeeList.size();
    }

    public List<Employee> getEmployeeList() {
        return Collections.unmodifiableList(this.employeeList);
    }

}

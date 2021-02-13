package softuni.advanced.examprep.Openning.src.bakery;

/** Description:
 * Our task is to create a bakery, which stores employees by creating the classes described below.
 * - class Employee with the following properties - name, age, country.
 * - class Bakery that has employees (a collection, which stores the entity Employee) - name and capacity.
 * We have to implement the following features:
 *
 * Method add(Employee employee) – adds an entity to the data if there is room for him/her.
 * Method remove(String name) – removes an employee by given name, if such exists, and returns bool.
 * Method getOldestEmployee() – returns the oldest employee.
 * Method getEmployee(string name) – returns the employee with the given name.
 * Getter getCount() – returns the number of employees.
 * report() – returns a string in the following format:
 * "Employees working at Bakery {bakeryName}:{Employee1}
 */

public class Main {
    public static void main(String[] args) {

        //Initialize the repository
        Bakery bakery = new Bakery("Barny", 10);
//Initialize entity
        Employee employee = new Employee("Stephen", 40, "Bulgaria");
//Print Employee
        System.out.println(employee); //Employee: Stephen, 40 (Bulgaria)

//Add Employee
        bakery.add(employee);
//Remove Employee
        System.out.println(bakery.remove("Employee name")); //false

        Employee secondEmployee = new Employee("Mark", 34, "UK");

//Add Employee
        bakery.add(secondEmployee);

        Employee oldestEmployee = bakery.getOldestEmployee(); // Employee with name Stephen
        Employee employeeStephen = bakery.getEmployee("Stephen"); // Employee with name Stephen
        System.out.println(oldestEmployee); //Employee: Stephen, 40 (Bulgaria)
        System.out.println(employeeStephen); //Employee: Stephen, 40 (Bulgaria)

        System.out.println(bakery.getCount()); //2

        System.out.println(bakery.report());
//Employees working at Bakery Barny:
//Employee: Stephen, 40 (Bulgaria)
//Employee: Mark, 34 (UK)

    }
}

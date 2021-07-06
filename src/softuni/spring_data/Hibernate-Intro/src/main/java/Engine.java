import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Please enter exercise number:");
        try {
            int exNumber = Integer.parseInt(bufferedReader.readLine());

            switch (exNumber) {
                case 2:
                    exerciseTwo();
                    break;
                case 3:
                    exerciseThree();
                    break;
                case 4:
                    exerciseFour();
                    break;
                case 5:
                    exerciseFive();
                    break;
                case 6:
                    exerciseSix();
                    break;
                case 7:
                    exerciseSeven();
                    break;
                case 8:
                    exerciseEight();
                    break;
                case 9:
                    exerciseNine();
                    break;
                case 10:
                    exerciseTen();
                    break;
                case 11:
                    exerciseEleven();
                    break;
                case 12:
                    exerciseTwelve();
                    break;
                case 13:
                    exerciseThirteen();
                    break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }


    private void exerciseTwo() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t SET t.name = upper(t.name)" +
                " WHERE length(t.name) <= 5");

        System.out.println(query.executeUpdate());

        entityManager.getTransaction().commit();
    }

    private void exerciseThree() throws IOException {
        System.out.println("Please enter user full name:");
        String[] fullName = bufferedReader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long singleResult = entityManager.createQuery("SELECT count(e) FROM Employee e " +
                "WHERE e.firstName = :f_name AND e.lastName = :l_name", Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();

        System.out.println(singleResult == 0 ? "No" : "Yes");
    }

    private void exerciseFour() {
        entityManager.createQuery("SELECT e FROM Employee e" +
                " WHERE e.salary > :min_salary", Employee.class)
                .setParameter("min_salary", BigDecimal.valueOf(50000L))
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private void exerciseFive() {
        entityManager.createQuery("SELECT e FROM Employee e" +
                " WHERE e.department.name = :d.name" +
                " ORDER BY e.salary, e.id", Employee.class)
                .setParameter("d.name", "Research and Development")
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s from %s - $%.2f%n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getDepartment().getName(),
                            employee.getSalary());
                });
    }

    private void exerciseSix() throws IOException {
        System.out.println("Please enter employee last name:");
        String lastName = bufferedReader.readLine();

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e" +
                " WHERE e.lastName = :l_name", Employee.class)
                .setParameter("l_name", lastName)
                .getSingleResult();

        Address address = createAddress("Vitoshka 15");

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }

    private void exerciseSeven() {
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a" +
                " ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        addresses.forEach(address -> {
            System.out.printf("%s , %s - %d employees%n",
                    address.getText(),
                    address.getTown() == null ? "Unknown" : address.getTown().getName(),
                    address.getEmployees().size());
        });
    }

    private void exerciseEight() throws IOException {
        System.out.println("Please enter employee ID:");
        int employeeId = Integer.parseInt(bufferedReader.readLine());
        Employee employee = entityManager.find(Employee.class, employeeId);

        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.println(p.getName()));
    }

    private void exerciseNine() {
        List<Project> resultList = entityManager
                .createQuery("SELECT p FROM Projects p" +
                        " ORDER BY p.start_date DESC", Project.class)
                .setMaxResults(10)
                .getResultList();

        resultList.stream().forEach(project -> {
            System.out.println("Project name: " + project.getName());
            System.out.println("Project description: " + project.getDescription());
            System.out.println("Project Start Date: " + project.getStartDate());
            System.out.println("Project End Date: " + project.getEndDate());
        });
    }

    private void exerciseTen() {
        entityManager.getTransaction().begin();
        int affectedRows = entityManager
                .createQuery("UPDATE Employee e SET e.salary = e.salary * 1.2 WHERE e.department.id IN :ids")
                .setParameter("ids", Set.of(1, 2, 4, 11))
                .executeUpdate();

        entityManager.getTransaction().commit();
        System.out.println(affectedRows);
    }

    private void exerciseEleven() throws IOException {
        System.out.println("Please enter first name:");
        String firstName = bufferedReader.readLine();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e" +
                " WHERE e.firstName LIKE CONCAT(:first_name, '%')", Employee.class)
                .setParameter("first_name", firstName)
                .getResultList();

        employees.stream().forEach(employee -> {
            System.out.printf("%s %s - %s - ($%.2f)%n",
                    employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary());
        });

    }

    @SuppressWarnings("unchecked")
    private void exerciseTwelve() {
        List<Object[]> rows = entityManager.createNativeQuery("SELECT d.name, MAX(e.salary) AS `m_salary` " +
                "FROM departments AS d " +
                "JOIN employees AS e " +
                "ON d.department_id = e.department_id " +
                "GROUP BY d.name " +
                "HAVING m_salary NOT BETWEEN 30000 and 70000;")
                .getResultList();

    }

    private void exerciseThirteen() throws IOException {
        System.out.println("Please enter town name:");
        String townName = bufferedReader.readLine();

        Town town = entityManager.createQuery("SELECT t FROM Town t WHERE t.name = :t_name", Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();

        entityManager.getTransaction().begin();
        int affectedRows = removeAddressById(town.getId());
        entityManager.remove(town);
        entityManager.getTransaction().commit();
        System.out.printf("%d address in %s is deleted.", affectedRows, townName);
    }

    private int removeAddressById(Integer id) {

        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a WHERE a.town.id = :p_id", Address.class)
                .setParameter("p_id", id)
                .getResultList();

        entityManager.getTransaction().begin();
        addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();

        return addresses.size();
    }




}

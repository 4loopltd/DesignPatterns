package _4loop.composite;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ManagerComposite implements EmployeeComponent {

    private final String role;
    private final String name;
    private final double salary;

    public ManagerComposite(String role, String name, double salary) {
        this.role = role;
        this.name = name;
        this.salary = salary;
    }

    final List<EmployeeComponent> employees = new ArrayList<>();

    @Override
    public void add(EmployeeComponent employee) {
        employees.add(employee);
    }

    @Override
    public void remove(EmployeeComponent employee) {
        employees.remove(employee);
    }

    @Override
    public EmployeeComponent getChild(int i) {
        return employees.get(i);
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void print() {
        log.info("Role: " + getRole());
        log.info("Name: " + getName());
        log.info("Salary: " + getSalary());
        log.info("Line Manages " + employees.size() + " employees.");

        for (EmployeeComponent employee : employees) {
            employee.print();
            log.info("");
        }
    }

}

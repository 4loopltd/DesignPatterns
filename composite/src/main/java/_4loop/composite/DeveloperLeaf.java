package _4loop.composite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeveloperLeaf implements EmployeeComponent {

    private final String role;
    private final String name;
    private final double salary;

    public DeveloperLeaf(String role, String name, double salary) {
        this.role = role;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void add(EmployeeComponent employee) {
        //Leaf
    }

    @Override
    public void remove(EmployeeComponent employee) {
        //Leaf
    }

    @Override
    public EmployeeComponent getChild(int i) {
        //Leaf
        return null;
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
    }

}

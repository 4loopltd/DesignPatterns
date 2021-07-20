package _4loop.composite;

public interface EmployeeComponent {
    void add(EmployeeComponent employee);

    void remove(EmployeeComponent employee);

    EmployeeComponent getChild(int i);

    String getRole();

    String getName();

    double getSalary();

    void print();
}

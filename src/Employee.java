import java.util.Objects;

public class Employee {


    private String name;
    private int department;
    private int salary;
    private static int counter = 0;
    private int id;

    public int getId() {
        id = counter++;
        return id;
    }

    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public static int calculateSalaryMin(Employee[] employees) {
        int min = employees[0].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
            }
        }
        return min;
    }

    public static Employee findEmployeeWithMinSalary(Employee[] employees) {
        Employee min = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() < min.getSalary()) {
                min = employees[i];
            }
        }
        return min;
    }

    public static Employee findEmployeeWithMaxSalary(Employee[] employees) {
        Employee max = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() > max.getSalary()) {
                max = employees[i];
            }
        }
        return max;
    }

    public static int calculateSalaryMax(Employee[] employees) {
        int max = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
            }
        }
        return max;
    }

    public static int calculateSalary(Employee[] employees) {
        int total = 0;
        for (int i = 0; i < employees.length; i++) {
            total += employees[i].getSalary();
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, id);
    }

    @Override
    public String toString() {
        return name + ", отдел №" + department + ", зарплата " + salary;
    }

}

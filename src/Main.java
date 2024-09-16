public class Main {

    public static Employee createEmployee(String name, int department, int salary) {
        Employee employee = new Employee(name, department, salary);
        return employee;
    }

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        //Базовая сложность
        System.out.println("Базовая сложность");
        System.out.println("Получить список всех сотрудников со всеми имеющимися по ним данными");
        employees[0] = createEmployee("Иванов Иван Иванович", 1, 1000);
        employees[1] = createEmployee("Петров Петр Петрович", 2, 2000);
        employees[2] = createEmployee("Сидоров Сергей Сергеевич", 3, 3000);
        employees[3] = createEmployee("Васильев Владимир Владимирович", 4, 4000);
        employees[4] = createEmployee("Федоров Федор Федорович", 5, 5000);
        employees[5] = createEmployee("Кузнецова Ирина Александровна", 1, 6000);
        employees[6] = createEmployee("Попова Елена Вадимовна", 2, 7000);
        employees[7] = createEmployee("Соколова Светлана Алексеевна", 3, 8000);
        employees[8] = createEmployee("Морозова Мария Владимировна", 4, 9000);
        employees[9] = createEmployee("Семенова Юлия Максимовна", 5, 10000);
        //Получить список всех сотрудников со всеми имеющимися по ним данными
        // (вывести в консоль значения всех полей (toString))
        print();

        //Найти сотрудника с МИНимальной ЗП
        System.out.println();
        System.out.println("Найти сотрудника с МИНимальной ЗП");
        System.out.println(findEmployeeWithMinSalary());

        //Найти сотрудника с МАКсимальной ЗП
        System.out.println();
        System.out.println("Найти сотрудника с МАКсимальной ЗП");
        System.out.println(findEmployeeWithMaxSalary());

        //Посчитать СУММУ затрат на ЗП в месяц
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц = " + calculateSalary());

        //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b)
        System.out.println();
        System.out.println("Среднее значение зарплат = " + calculateSalary() / employees.length);

        //Распечатать ФИО всех сотрудников
        System.out.println();
        System.out.println("Распечатать ФИО всех сотрудников");
        print2();

        System.out.println();

        System.out.println("Повышенная сложность");
        System.out.println("____________________");
        //Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)

        System.out.println("Проиндексировать зарплату на %");
        indexSalaries(0.5);

        //Сотрудник с МИНимальной зп по отделу
        System.out.println("");
        System.out.println("Сотрудник с МИНимальной ЗП по отделу:");
        System.out.println(employeesMinSalary(1));

        //Сотрудник с МАКимольной ЗП по отделу
        System.out.println("");
        System.out.println("Сотрудник с МАКимальной ЗП по отделу:");
        System.out.println(employeesMaxSalary(1));

        //Найти сумму затрат на ЗП по отделу
        System.out.println("");
        System.out.println("Сумму затрат на зп по отделу  =" + amountCostsDepartment(1));

        //Найти среднюю ЗП по отделу
        System.out.println("");
        System.out.println("Средняя сумма зп по отделу:  =" + averageCostAmountDepartment(1));

        //Получить в качестве параметра номер отдела (1-5)
        System.out.println("");
        System.out.println("Напечатать всех сотрудников отдела (все данные, кроме отдела)");
        totalDepartment(1);

        //Вывести сотрудников с зп МЕНЬШЕ числа
        System.out.println("");
        System.out.println("Сотрудники с зп меньше числа:");
        employeesLessSalary(4500);

        //Вывести сотрудников с зп БОЛЬШЕ числа
        System.out.println("");
        System.out.println("Сотрудники с зп больше числа:");
        employeesHigherSalary(4500);

    }

    public static int averageCostAmountDepartment(int departmentId) {
        int total = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == departmentId) {
                total += employee.getSalary() / 2;
            }
        }
        return total;
    }

    //Найти сумму затрат на зп по отделу
    public static int amountCostsDepartment(int departmentId) {
        int total = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == departmentId) {
                total += employee.getSalary();
            }
        }
        return total;
    }

    //Найти сотрудника с минимальной зп по отделу
    private static Employee employeesMinSalary(int departmentId) {
        Employee min = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == departmentId) {
                if (min == null || min.getSalary() > employee.getSalary()) {
                    min = employee;

                }
            }
        }
        return min;
    }

    //Найти сотрудника с макимальной зп по отделу
    private static Employee employeesMaxSalary(int departmentId) {
        Employee min = null;
        for (Employee employee : employees) {
            if (employee.getDepartment() == departmentId) {
                if (min == null || min.getSalary() < employee.getSalary()) {
                    min = employee;

                }
            }
        }
        return min;
    }

    //Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public static Employee totalDepartment(int departmentId) {
        Employee departmentEmployees = employees[0];
        for (Employee employee : employees) {
            if (employee.getDepartment() == departmentId)
                System.out.println("id:" + employee.getId() + " " + employee.getName() + ", зарплата " + employee.getSalary());
        }
        return departmentEmployees;
    }

    //Найти сотрудника с МИНимальной ЗП
    public static Employee findEmployeeWithMinSalary() {
        Employee min = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < min.getSalary()) {
                min = employee;
            }
        }
        return min;
    }

    //Найти сотрудника с МАКсимальной ЗП
    public static Employee findEmployeeWithMaxSalary() {
        Employee max = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > max.getSalary()) {
                max = employee;
            }
        }
        return max;
    }

    //Посчитать СУММУ затрат на ЗП в месяц
    private static int calculateSalary() {
        int total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        return total;
    }

    //Проиндексировать зарплату
    public static void indexSalaries(double indexationRate) {
        for (Employee employee : employees) {
            double indexedSalary = employee.getSalary() + (employee.getSalary() * indexationRate);
            employee.setSalary((int) indexedSalary);
            System.out.println(employee.getName() + ", зарплата " + indexedSalary);
        }
    }

    //Все сотрудники с зп МЕНЬШЕ числа (распечатать id, фио и зп в консоль)
    public static Employee employeesLessSalary(int minNumber) {
        Employee min = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < minNumber) {
                min = employee;
                System.out.println("id:" + employee.getId() + " " + employee);
            }
        }
        return min;
    }

    //Все сотрудники с зп БОЛЬШЕ (или равно) числа (распечатать id, фио и зп в консоль)
    public static Employee employeesHigherSalary(int maxNumber) {
        Employee min = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() >= maxNumber) {
                min = employee;
                System.out.println("id:" + employee.getId() + " " + employee);
            }
        }
        return min;
    }

    //Распечатать ФИО всех сотрудников
    public static void print2() {
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    //Получить список всех сотрудников со всеми имеющимися по ним данными
    public static void print() {
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId() + " " + employee);
        }
    }

}
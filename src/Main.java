
public class Main {

    public static void main(String[] args) {

        //Базовая сложность
        System.out.println("Базовая сложность");
        Employee[] employees = new Employee[10];
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
        for (int i = 0; i < employees.length; i++) {
            System.out.println("id:" + employees[i].getId() + " " + employees[i]);
        }

        //Найти сотрудника с МИНимальной ЗП
        System.out.println();
        System.out.println("Сотрудник с минимальной ЗП = " + Employee.calculateSalaryMin(employees));
        System.out.println(Employee.findEmployeeWithMinSalary(employees));

        //Найти сотрудника с МАКсимальной ЗП
        System.out.println();
        System.out.println("Сотрудник с максимальной ЗП = " + Employee.calculateSalaryMax(employees));
        System.out.println(Employee.findEmployeeWithMaxSalary(employees));

        //Посчитать СУММУ затрат на ЗП в месяц
        System.out.println();
        System.out.println("Сумма затрат на ЗП в месяц = " + Employee.calculateSalary(employees));

        //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b)
        System.out.println();
        System.out.println("Среднее значение зарплат = " + Employee.calculateSalary(employees) / employees.length);

        //Распечатать ФИО всех сотрудников
        System.out.println();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getName());
        }
    }

    public static Employee createEmployee(String name, int department, int salary) {
        Employee employee = new Employee(name, department, salary);
        return employee;
    }
}